package org.example.controller;

import org.example.exception.AgeException;
import org.example.exception.MyUserException;
import org.example.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        System.out.println("doSome 方法");

        if (!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }

        if (age == null||age.intValue()>80){
            throw new AgeException("年龄不符合");
        }

        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        //结果结果
        return mv;
    }

}
