package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {
    @RequestMapping("/user/account")
    @ResponseBody
    public String userAccount() {
        return "访问 user/account";
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public String userLogin() {
        return "访问 user/Login";
    }
}
