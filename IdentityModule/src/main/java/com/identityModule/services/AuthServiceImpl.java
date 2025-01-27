package com.identityModule.services;


import com.identityModule.dtos.JwtResponseDTO;
import com.identityModule.models.User;
import com.identityModule.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public String createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User has been created successfully.";
    }

    @Override
    public JwtResponseDTO generateToken(String username) {
        User user = userRepository.findByUsername(username);
        return JwtResponseDTO.builder().accessToken(jwtService.generateToken(user)).build();
    }

    @Override
    public void validateToken(String jwtToken) {
        String username = jwtService.extractUsername(jwtToken);
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
        jwtService.validateToken(jwtToken, userDetails);
    }


    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }


}