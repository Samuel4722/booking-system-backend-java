/*
 * package com.portfolio.projekt.security;
 * 
 * import org.springframework.boot.CommandLineRunner; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration public class DevConfig {
 * 
 * @Bean public PasswordEncoder passwordEncoderDev() { return new BCryptPasswordEncoder(); }
 * 
 * @Bean public CommandLineRunner printPasswordHash(PasswordEncoder passwordEncoderDev) { return
 * args -> { String raw = "password"; String hash = passwordEncoderDev.encode(raw);
 * System.out.println("=== GENERATED HASH FOR 'password' ==="); System.out.println(hash);
 * System.out.println("====================================="); }; } }
 */
