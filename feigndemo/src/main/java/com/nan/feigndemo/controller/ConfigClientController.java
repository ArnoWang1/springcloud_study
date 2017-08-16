package com.nan.feigndemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${user.desc}")
    private String userDesc;

    @RequestMapping("/userdesc")
    public String getUserDesc() {
        return userDesc;
    }

}
