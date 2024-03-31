package com.mygitgor.springsecurity.service;

import com.mygitgor.springsecurity.entities.Role;
import com.mygitgor.springsecurity.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole(){
       return roleRepository.findByName("ROLE_USER").get();
    }
}
