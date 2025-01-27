package com.identityModule.controllers;

import com.identityModule.dtos.AuthRequestDTO;
import com.identityModule.dtos.JwtResponseDTO;
import com.identityModule.models.User;
import com.identityModule.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody User user){
        try{
            return ResponseEntity.ok(authService.createUser(user));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @PostMapping("/generateToken")
    public ResponseEntity<JwtResponseDTO> generateToken(@RequestBody AuthRequestDTO authRequestDTO){
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
            if(authentication.isAuthenticated()){
                return ResponseEntity.ok(authService.generateToken(authRequestDTO.getUsername()));
            } else {
                throw new RuntimeException("Invalid User Request..!");
            }

        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @GetMapping("/validateToken")
    public String validateToken(@RequestParam String jwtToken){
        try{
            authService.validateToken(jwtToken);
            return "Token is valid.!";
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        try {
            List<User> userResponses = authService.getAllUser();
            return ResponseEntity.ok(userResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

/*    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/forUser")
    public String testUser() {
        try {
            return "Welcome to User";
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/forAdmin")
    public String testAdmin() {
        try {
            return "Welcome to Admin";
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/


}