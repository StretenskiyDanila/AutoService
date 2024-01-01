package ru.stretenskiy.autoservice.services;

import ru.stretenskiy.autoservice.entities.User;
import ru.stretenskiy.autoservice.security.JwtUserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Long saveUser(User user);

    Optional<User> findByUsername(String username);

    JwtUserDetails authenticate(String username, String password);

    User getUser(Long id);

    User getUser(String userName);

}
