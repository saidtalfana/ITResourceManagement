package com.ResourceManagement.IT.controller;

import com.ResourceManagement.IT.config.JwtAuth;
import com.ResourceManagement.IT.dto.LoginRequest;
import com.ResourceManagement.IT.dto.SignupRequest;
import com.ResourceManagement.IT.enums.Role;
import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class PersonController {



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonService personService;



    @PostMapping("signup")
    public ResponseEntity<Person> signUp(@RequestParam Role role, @RequestBody SignupRequest signUpRequest) {
        Person createPerson = personService.signUp(role, signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPerson);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Person person = personService.findByUsername(loginRequest.getUsername());
        String token = JwtAuth.generateToken(person.getUsername(), person.getRoles());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
