package com.mygitgor.springsecurity.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private Long id;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
