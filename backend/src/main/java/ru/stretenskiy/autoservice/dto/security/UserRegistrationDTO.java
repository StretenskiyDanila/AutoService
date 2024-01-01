package ru.stretenskiy.autoservice.dto.security;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.User;

@Data
public class UserRegistrationDTO {

    private String username;
    private String password;

    public User fromDTO() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

}
