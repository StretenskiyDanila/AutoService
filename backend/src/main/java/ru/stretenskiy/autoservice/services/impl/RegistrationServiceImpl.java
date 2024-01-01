package ru.stretenskiy.autoservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.User;
import ru.stretenskiy.autoservice.repositories.UserRepository;
import ru.stretenskiy.autoservice.services.RegistrationService;
import ru.stretenskiy.autoservice.services.UserService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Long register(User user) {
        String password = new String(Base64.getDecoder().decode(user.getPassword()), StandardCharsets.UTF_8);
        user.setPassword(password);
        return userService.saveUser(user);
    }

    @Override
    public boolean checkUserExistsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

}
