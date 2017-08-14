package com.nan.feigndemo.client;

import com.nan.feigndemo.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "UserService", fallback = UserServiceClientFallback.class)
public interface UserServiceClient {

    @RequestMapping("/user/{id}")
    User findOne(@PathVariable("id") Long id);

}
