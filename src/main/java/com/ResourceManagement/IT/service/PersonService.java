package com.ResourceManagement.IT.service;

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



    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }
}

