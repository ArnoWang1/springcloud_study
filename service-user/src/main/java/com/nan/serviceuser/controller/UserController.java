package com.nan.serviceuser.controller;

import com.nan.serviceuser.model.User;
import com.nan.serviceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}")
    public User findOne(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

}
