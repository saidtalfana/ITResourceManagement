package com.ResourceManagement.IT.service;

import com.ResourceManagement.IT.enums.Role;
import com.ResourceManagement.IT.model.Admin;
import com.ResourceManagement.IT.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Admin addAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Set<Role> role = new HashSet<>();
        role.add(Role.ADMIN);
        admin.setRoles(role);
         return adminRepository.save(admin);
     }
}
