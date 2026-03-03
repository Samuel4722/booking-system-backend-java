package com.portfolio.projekt.dto;

import com.portfolio.projekt.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private Role role;
}
