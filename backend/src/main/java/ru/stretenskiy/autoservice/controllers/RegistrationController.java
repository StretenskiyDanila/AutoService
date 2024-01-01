package ru.stretenskiy.autoservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stretenskiy.autoservice.dto.security.UserRegistrationDTO;
import ru.stretenskiy.autoservice.entities.User;
import ru.stretenskiy.autoservice.services.RegistrationService;

@RestController
@Slf4j
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserRegistrationDTO userDTO) {
        if (registrationService.checkUserExistsByUsername(userDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User user = userDTO.fromDTO();

        try {
            Long userId = registrationService.register(user);
            return ResponseEntity.ok().body("New user crated successfully with id: " + userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error when creating user: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Boolean> checkExists(@RequestParam(value = "username") String username) {
        return ResponseEntity.ok(registrationService.checkUserExistsByUsername(username));
    }

}
