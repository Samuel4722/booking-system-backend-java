package com.portfolio.projekt.controller;

import com.portfolio.projekt.dto.AuthResponse;
import com.portfolio.projekt.dto.LoginRequest;
import com.portfolio.projekt.dto.RegisterRequest;
import com.portfolio.projekt.entity.User;
import com.portfolio.projekt.repository.UserRepository;
import com.portfolio.projekt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/me")
    public User getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
