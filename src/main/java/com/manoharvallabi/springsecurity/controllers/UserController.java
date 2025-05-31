package com.manoharvallabi.springsecurity.controllers;

import com.manoharvallabi.springsecurity.model.Users;
import com.manoharvallabi.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users registerStudent(@RequestBody Users user)
    {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user)
    {
        System.out.println("in login method");
        return userService.verify(user);
    }
}
