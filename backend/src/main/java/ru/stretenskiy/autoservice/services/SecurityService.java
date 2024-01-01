package ru.stretenskiy.autoservice.services;

import org.springframework.core.io.ByteArrayResource;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
