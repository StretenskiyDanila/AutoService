package ru.stretenskiy.autoservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.stretenskiy.autoservice.dto.security.JwtRequestDTO;
import ru.stretenskiy.autoservice.security.JwtUserDetails;

public interface LoginService {

    JwtUserDetails login(JwtRequestDTO user) throws JsonProcessingException;

    JwtUserDetails getCurrentUser();

}
