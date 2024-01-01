package ru.stretenskiy.autoservice.services;

import ru.stretenskiy.autoservice.entities.User;

public interface RegistrationService {

    Long register(User user);

    boolean checkUserExistsByUsername(String username);

}
