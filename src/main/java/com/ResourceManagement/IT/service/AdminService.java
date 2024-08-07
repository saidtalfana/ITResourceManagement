package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.AdminRepository;
import com.ResourceManagement.IT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private com.ResourceManagement.IT.repository.UserRepository UserRepository;

    public User addUser(User user) {
        return UserRepository.save(user);
    }
}
