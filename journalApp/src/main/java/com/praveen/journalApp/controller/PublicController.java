package com.praveen.journalApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.praveen.journalApp.entity.User;
import com.praveen.journalApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PublicController {
    
    @GetMapping("/public")
    public String healthCheck(){
        return "OK";
    }

    @Autowired
    private UserService userService;

    @PostMapping("create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
