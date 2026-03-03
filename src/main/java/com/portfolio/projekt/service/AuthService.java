package com.portfolio.projekt.service;

import com.portfolio.projekt.dto.AuthResponse;
import com.portfolio.projekt.dto.LoginRequest;
import com.portfolio.projekt.dto.RegisterRequest;
import com.portfolio.projekt.entity.User;
import com.portfolio.projekt.repository.UserRepository;
import com.portfolio.projekt.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder().email(request.getEmail()).username(request.getName())
                .password(passwordEncoder.encode(request.getPassword())).role(request.getRole())
                .build();

        userRepository.save(user);

        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                        .password(user.getPassword()).roles(user.getRole().name()).build();

        String token = jwtService.generateToken(userDetails);

        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse login(LoginRequest request) {

        String login = request.getLogin();
        User user;

        if (login.contains("@")) {
            user = userRepository.findByEmail(login)
                    .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        } else {
            user = userRepository.findByUsername(login)
                    .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        }

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!matches) {
            throw new RuntimeException("Invalid credentials");
        }

        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                        .password(user.getPassword()).roles(user.getRole().name()).build();

        String token = jwtService.generateToken(userDetails);

        return AuthResponse.builder().token(token).build();
    }

}
