package com.mygitgor.springsecurity.service;

import com.mygitgor.springsecurity.dto.RegistrationUserDto;
import com.mygitgor.springsecurity.entities.User;
import com.mygitgor.springsecurity.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Setter
@Getter
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
    }

    public User createNewUser(RegistrationUserDto registrationUserDto){
        User user = new User();
        user.setUsername(registrationUserDto.getUsername());
        user.setEmail(registrationUserDto.getEmail());
        user.setPassword(registrationUserDto.getPassword());
        user.setRoles(List.of(roleService.getUserRole()));
        return userRepository.save(user);
    }


}
