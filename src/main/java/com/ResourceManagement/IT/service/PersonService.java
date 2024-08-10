package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.dto.SignupRequest;
import com.ResourceManagement.IT.enums.Role;
import com.ResourceManagement.IT.model.Admin;
import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.model.Technician;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;




    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    public Person signUp(Role role, SignupRequest signUpRequest) {
        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        Person person;
        switch (role) {
            case ADMIN:
                person = new Admin();
                person.setRoles( Role.ADMIN);
                break;
            case USER:
                person = new User();
                person.setRoles(Role.USER);
                break;
            case TECHNICIAN:
                person = new Technician()  ;
                person.setRoles(Role.TECHNICIAN);
                break;
            default:
                throw new IllegalArgumentException("Invalid person type");
        }

        person.setUsername(signUpRequest.getUsername());
        person.setName(signUpRequest.getName());
        person.setEmail(signUpRequest.getEmail());
        person.setPassword(hashedPassword);

        return personRepository.save(person);    }
}

