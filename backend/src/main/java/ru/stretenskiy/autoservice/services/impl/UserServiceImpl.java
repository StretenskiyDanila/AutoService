package ru.stretenskiy.autoservice.services.impl;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.User;

import ru.stretenskiy.autoservice.repositories.RoleRepository;
import ru.stretenskiy.autoservice.repositories.UserRepository;
import ru.stretenskiy.autoservice.security.JwtUserDetails;
import ru.stretenskiy.autoservice.security.jwt.JwtUtils;
import ru.stretenskiy.autoservice.services.UserService;
import ru.stretenskiy.autoservice.utils.RoleAuthorities;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public Long saveUser(@NotNull User user) {
        user.setRoles(Collections.singleton(roleRepository.findByName(RoleAuthorities.ADMIN.name()).orElseThrow()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("User with username = {} saved", user.getUsername());
        return userRepository.save(user).getId();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public JwtUserDetails authenticate(String username, String password) {
        String jwt;
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                password));
        SecurityContextHolder.getContext().setAuthentication(auth);
        jwt = jwtUtils.generateJwtToken(auth);
        ((JwtUserDetails) auth.getPrincipal()).setToken(jwt);

        return (JwtUserDetails) auth.getPrincipal();
     }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id: " + id +
                " not found!"));
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUsername(userName).orElseThrow(() ->
                new EntityNotFoundException("User " + userName + " not found!"));
    }

}
