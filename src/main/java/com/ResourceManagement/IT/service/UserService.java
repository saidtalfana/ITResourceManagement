package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.enums.Role;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void deleteUser(long id){
            userRepository.deleteById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User updateUser(User user, long id){
        User updateUser = userRepository.findById(id).get();

        updateUser.setName(user.getName());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());

        return userRepository.save(updateUser);

    }
}
