package com.mygitgor.springsecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/nosecret")
    public String noSecretEnv(){
        return "nosecretEnv";
    }

    @GetMapping("/secret")
    public String secretEnv(){
        return "secretEnv";
    }

    @GetMapping("admin")
    public String adminEnv(){
        return "adminEnv";
    }

    @GetMapping("/info")
    public String userEnv(Principal principal){
        return principal.getName();
    }



}
