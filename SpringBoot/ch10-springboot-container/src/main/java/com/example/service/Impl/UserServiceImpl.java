package com.example.service.Impl;

import com.example.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void sayHello(String name) {
        System.out.println("执行了 sayHello !" + name);
    }
}
