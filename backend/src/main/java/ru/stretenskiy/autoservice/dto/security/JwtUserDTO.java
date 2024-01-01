package ru.stretenskiy.autoservice.dto.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import ru.stretenskiy.autoservice.entities.Role;
import ru.stretenskiy.autoservice.entities.User;
import ru.stretenskiy.autoservice.security.JwtUserDetails;

import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JwtUserDTO extends UserDTO {

    private String token;

    public static JwtUserDTO toDTO(User user, String token) {
        JwtUserDTO jwtUserDTO = new JwtUserDTO();
        jwtUserDTO.setToken(token);
        jwtUserDTO.setId(user.getId());
        jwtUserDTO.setUsername(user.getUsername());
        jwtUserDTO.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));

        return jwtUserDTO;
    }

    public static JwtUserDTO toDTO(JwtUserDetails jwtUserDetails) {
        JwtUserDTO jwtUserDTO = new JwtUserDTO();
        jwtUserDTO.setToken(jwtUserDetails.getToken());
        jwtUserDTO.setId(jwtUserDetails.getId());
        jwtUserDTO.setUsername(jwtUserDetails.getUsername());
        jwtUserDTO.setRoles(jwtUserDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));

        return jwtUserDTO;
    }

}
