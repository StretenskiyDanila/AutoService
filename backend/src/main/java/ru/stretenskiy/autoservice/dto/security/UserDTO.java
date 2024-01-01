package ru.stretenskiy.autoservice.dto.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.stretenskiy.autoservice.entities.Role;
import ru.stretenskiy.autoservice.entities.User;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Set<String> roles;

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        return userDTO;
    }

    public User fromDTO() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

}
