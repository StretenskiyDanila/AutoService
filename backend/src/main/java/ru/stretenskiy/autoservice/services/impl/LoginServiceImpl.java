package ru.stretenskiy.autoservice.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stretenskiy.autoservice.dto.security.JwtRequestDTO;
import ru.stretenskiy.autoservice.security.JwtUserDetails;
import ru.stretenskiy.autoservice.services.LoginService;
import ru.stretenskiy.autoservice.services.UserService;
import ru.stretenskiy.autoservice.services.security.UserDetailsServiceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public JwtUserDetails login(JwtRequestDTO user) throws JsonProcessingException {
        String password = new String(Base64.getDecoder().decode(user.getPassword()), StandardCharsets.UTF_8);
        return userService.authenticate(user.getUsername(), password);
    }

    @Override
    public JwtUserDetails getCurrentUser() {
        return userDetailsService.getCurrentUser();
    }

}
