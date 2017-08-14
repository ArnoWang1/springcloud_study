package com.nan.feigndemo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HelloService", fallback = HelloServiceClientFallback.class)
public interface HelloServiceClient {

    @RequestMapping("/hello")
    String hello(@RequestParam("name") String name);

}
