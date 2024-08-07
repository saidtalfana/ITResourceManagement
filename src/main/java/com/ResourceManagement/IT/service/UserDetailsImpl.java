package com.ResourceManagement.IT.service;


import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findBYUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException("person not found with username: " + username);
        }
        return person;
    }
}
