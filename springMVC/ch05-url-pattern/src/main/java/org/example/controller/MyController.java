package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/some")
    public ModelAndView doReturnStringView1(String name, Integer age) {
        System.out.println("执行了 MyController 的 doReturnStringView1 方法，name = " + name + " age = " + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("show");
        return mv;
    }
}
