package com.ResourceManagement.IT.controller;

import com.ResourceManagement.IT.model.Admin;
import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.model.Technician;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.service.AdminService;
import com.ResourceManagement.IT.service.TechnicianService;
import com.ResourceManagement.IT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private TechnicianService technicianService;

//    @Autowired

    @PostMapping("/save_admin")
    public Person save(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping("/save_user")
    public Person save(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/save_technician")
    public Person save(@RequestBody Technician technician) {
        return technicianService.addTechnician(technician);

    }


}
