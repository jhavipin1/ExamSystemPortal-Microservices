package com.identityModule.services;

import com.identityModule.dtos.JwtResponseDTO;
import com.identityModule.models.User;

import java.util.List;

public interface AuthService {
    String createUser(User user);

    JwtResponseDTO generateToken(String username);

    void validateToken(String jwtToken);

    List<User> getAllUser();
}
