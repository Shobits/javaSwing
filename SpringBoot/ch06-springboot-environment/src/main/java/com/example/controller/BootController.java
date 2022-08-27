package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {
    @RequestMapping("/doSome")
    @ResponseBody
    public String doSome() {
        return "hello SpringBoot 应用，设置端口 80";
    }

}
