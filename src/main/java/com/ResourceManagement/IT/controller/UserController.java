package com.ResourceManagement.IT.controller;


import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.service.PersonService;
import com.ResourceManagement.IT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/get_users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PutMapping("/update_user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
       return userService.updateUser(user, id);
    }







}

