package ru.stretenskiy.autoservice.services.impl;

import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.User;

import ru.stretenskiy.autoservice.repositories.RoleRepository;
import ru.stretenskiy.autoservice.repositories.UserRepository;
import ru.stretenskiy.autoservice.services.UserService;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveUser(@NotNull User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        log.info("User with username = {} saved", user.getUsername());
        return userRepository.save(user).getId();
    }

    @Override
    @Transactional
    public void deleteUser(@NotNull User user) {
        log.info("User with username = {} deleted", user.getUsername());
        userRepository.delete(user);
    }

}
