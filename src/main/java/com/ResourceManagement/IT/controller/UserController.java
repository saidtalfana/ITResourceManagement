package com.ResourceManagement.IT.controller;


import com.ResourceManagement.IT.model.Person;
import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.service.PersonService;
import com.ResourceManagement.IT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private PersonService personService;
//
//    @PostMapping("add_user")
//    public String test(User user) {
//        personService.addPerson(user);
//        return "the add user is successful";
//    }

    @PostMapping("/one")
    public User test(@RequestBody User user) {
         return userService.addUser(user);
    }

}

