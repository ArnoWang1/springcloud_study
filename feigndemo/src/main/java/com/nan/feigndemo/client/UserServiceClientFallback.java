package com.nan.feigndemo.client;

import com.nan.feigndemo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClientFallback implements UserServiceClient {

    @Override
    public User findOne(Long id) {
        User user = new User();
        user.setId(0L);
        user.setAge(0);
        return user;
    }
}
