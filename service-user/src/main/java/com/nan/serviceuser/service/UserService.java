package com.nan.serviceuser.service;

import com.nan.serviceuser.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findOne(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("秦始皇");
        user.setAge(2300);
        return user;
    }

}
