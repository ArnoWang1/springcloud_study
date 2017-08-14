package com.nan.feigndemo.controller;

import com.nan.feigndemo.client.HelloServiceClient;
import com.nan.feigndemo.client.UserServiceClient;
import com.nan.feigndemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignDemoController {

    @Autowired
    private HelloServiceClient helloServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping("/feigndemo")
    public String feignDemo(@RequestParam("name") String name) {
        return helloServiceClient.hello(name);
    }

    @RequestMapping("/api-user/{id}")
    public User findOne(@PathVariable("id") Long id) {
        return userServiceClient.findOne(id);
    }
}
