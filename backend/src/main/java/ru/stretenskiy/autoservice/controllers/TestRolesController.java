package ru.stretenskiy.autoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stretenskiy.autoservice.auditing.ApplicationAuditAware;
import ru.stretenskiy.autoservice.entities.Role;
import ru.stretenskiy.autoservice.entities.User;
import ru.stretenskiy.autoservice.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestRolesController {

    private final ApplicationAuditAware aware;
    private final UserRepository userRepository;

    @GetMapping("/viewer")
    public ResponseEntity<List<String>> testViewer() {
        User user = userRepository.findById(aware.getCurrentAuditor().orElseThrow()).orElseThrow();
        return ResponseEntity.ok(List.of(user.getUsername(), user.getRoles().stream().map(Role::getName).collect(Collectors.joining())));
    }

    @GetMapping("/editor")
    public ResponseEntity<List<String>> testEditor() {
        User user = userRepository.findById(aware.getCurrentAuditor().orElseThrow()).orElseThrow();
        return ResponseEntity.ok(List.of(user.getUsername(), user.getRoles().stream().map(Role::getName).collect(Collectors.joining())));
    }

    @GetMapping("/any")
    public ResponseEntity<List<String>> testAny() {
        User user = userRepository.findById(aware.getCurrentAuditor().orElseThrow()).orElseThrow();
        return ResponseEntity.ok(List.of(user.getUsername(), user.getRoles().stream().map(Role::getName).collect(Collectors.joining())));
    }


}
