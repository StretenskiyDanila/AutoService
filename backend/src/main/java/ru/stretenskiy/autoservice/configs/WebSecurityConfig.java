package ru.stretenskiy.autoservice.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.stretenskiy.autoservice.security.jwt.AuthTokenFilter;
import ru.stretenskiy.autoservice.security.jwt.JwtCorsFilter;
import ru.stretenskiy.autoservice.utils.RoleAuthorities;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig{

    private static final String[] WHITE_LIST_URL = {"/services", "/masters", "/auth", "/auth/**",
            "/registration", "/services/**", "/masters/**"};

    private final AuthTokenFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final JwtCorsFilter filterCors;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "ResponseType"));
        configuration.setExposedHeaders(List.of("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return  source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeHttpRequests(req -> {
                            try {
                                req.antMatchers(WHITE_LIST_URL).permitAll()
                                        .antMatchers("/works/**").hasAuthority(RoleAuthorities.ADMIN.name())
                                        .antMatchers("/cars/**").hasAuthority(RoleAuthorities.ADMIN.name())
                                        .anyRequest()
                                        .authenticated();
//                                        .and()
//                                        .formLogin()
//                                        .loginPage("/auth")
//                                        .permitAll()
//                                        .and()
//                                        .logout()
//                                        .permitAll();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
