package ru.stretenskiy.autoservice.services;

import ru.stretenskiy.autoservice.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    Long saveUser(User user);

    void deleteUser(User user);

}
