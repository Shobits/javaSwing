package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
/*    @RequestMapping("/data")
        public String doJsp(HttpServletRequest request) {
        request.setAttribute("data","Springboot 使用 JSP");
        //视图的逻辑名称
        return "index";
    }*/

    /**
     * ModelAndView
     */
    @RequestMapping("/data")
    public String doJsp(Model model) {
        //把数据放到 request 作用域
        model.addAttribute("data", "Springboot 使用 JSP");
        //视图的逻辑名称
        return "index";
    }
}
