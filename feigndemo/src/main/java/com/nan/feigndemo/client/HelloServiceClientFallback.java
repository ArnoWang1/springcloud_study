package com.nan.feigndemo.client;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceClientFallback implements HelloServiceClient {

    @Override
    public String hello(String name) {
        return "Error: Hello service error";
    }

}
