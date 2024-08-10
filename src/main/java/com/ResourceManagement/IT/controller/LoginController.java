package com.ResourceManagement.IT.controller;

import com.ResourceManagement.IT.config.JwtAuth;
import com.ResourceManagement.IT.dto.JwtDto;
import com.ResourceManagement.IT.dto.LoginDto;
import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.service.PersonService;
import com.ResourceManagement.IT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public JwtDto login(@RequestBody LoginDto requestLogin) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestLogin.getUsername(), requestLogin.getPassword())
        );
        Person person = personService.findByUsername(requestLogin.getUsername());
        Set<String> roles = person.getRoles().stream()
                .map(role -> role.name())
                .collect(Collectors.toSet());
         Integer id = person.getId();
         String role = person.getRoles().toString();
        String token = JwtAuth.generateToken(requestLogin.getUsername(), roles);
        return new JwtDto(id, role,token);
    }
}
