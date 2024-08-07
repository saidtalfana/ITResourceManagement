package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.enums.Roles;
import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(User user) {
        Set<Roles> roles = new HashSet<>();
        roles.add(Roles.USER);
        user.setRoles(roles);
        return personRepository.save(user);
    }
}

