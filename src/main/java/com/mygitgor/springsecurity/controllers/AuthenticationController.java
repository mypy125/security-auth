package com.mygitgor.springsecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(){
        return null;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(){
        return null;
    }

}
