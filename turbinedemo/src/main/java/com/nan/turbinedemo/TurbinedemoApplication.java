package com.nan.turbinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbinedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbinedemoApplication.class, args);
    }
}
