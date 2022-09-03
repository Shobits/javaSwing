package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloThymeleaf {

    @GetMapping("/hello")
    public String helloThymeleaf(Model model, HttpServletRequest req) {
        //添加数据到 request 作用域，模板引擎可以从 request 中获取数据
        req.setAttribute("data", "欢迎使用 Thymeleaf模板引擎");

        //使用 model 存放数据
        model.addAttribute("mydata", "model 中的数据");

        //指定视图（模板引擎使用的页面（html））
        //逻辑名称
        return "hello";
    }
}
