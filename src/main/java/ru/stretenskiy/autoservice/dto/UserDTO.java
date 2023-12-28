package ru.stretenskiy.autoservice.dto;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.Role;
import ru.stretenskiy.autoservice.entities.User;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Set<String> roles;

    public static UserDTO buildUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        return userDTO;
    }

    public User buildUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

}
