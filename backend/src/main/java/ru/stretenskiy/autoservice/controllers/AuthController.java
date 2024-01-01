package ru.stretenskiy.autoservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stretenskiy.autoservice.dto.security.JwtRequestDTO;
import ru.stretenskiy.autoservice.dto.security.JwtUserDTO;
import ru.stretenskiy.autoservice.security.JwtUserDetails;
import ru.stretenskiy.autoservice.services.LoginService;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<JwtUserDTO> login(@RequestBody JwtRequestDTO user) throws JsonProcessingException {
        JwtUserDetails login = loginService.login(user);
        return ResponseEntity.ok(JwtUserDTO.toDTO(login));
    }

    @GetMapping("/current")
    public ResponseEntity<JwtUserDTO> getCurrentUser() {
        try {
            JwtUserDetails current = loginService.getCurrentUser();
            return ResponseEntity.ok(JwtUserDTO.toDTO(current));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
