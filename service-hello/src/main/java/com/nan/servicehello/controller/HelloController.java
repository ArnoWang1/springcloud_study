package com.nan.servicehello.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(@RequestParam String name) {
        return "Hello " + name + ", this client port is " + serverPort;
    }

    public String helloFallback(String name) {
        return name + ",this is fallback";
    }
}
