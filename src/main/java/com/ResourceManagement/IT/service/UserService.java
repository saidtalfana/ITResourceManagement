package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.enums.Roles;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.EquipmentRepository;
import com.ResourceManagement.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public User  addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Roles> role = new HashSet<Roles>();
     role.add(Roles.USER);
      user.setRoles(role);
        return UserRepository.save(user);
    }
}
