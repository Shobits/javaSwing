package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    /**
     *  转发操作：
     *      控制器方法返回的是 ModelAndView 实现转发 forward
     *      语法：mv.setViewName("forward:视图的完整路径");
     *
     *      forward 特点：不和解析器一同工作的，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doForward() {
        System.out.println("doForward 方法");

        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("fun", "执行了doSome方法");
        //显示使用 forward 指定转发操作
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        //结果结果
        return mv;
    }

    /**
     * 重定向操作：
     *      当控制器方法返回的 ModelAndView 实现重定向
     *      语法：mv.setViewName("redirect:视图的完整路径")
     *      redirect 特点：不和视图解析器一同工作，就当项目中没有视图解析器
     *
     * 框架提供的重定向的功能
     * 1.框架可以实现两次请求之间的数据传递，把第一个请求中的 ModeL 里面
     *   简单类型的数据，转为字符串，附加到目标页面的后面，做 get 参数传递。
     *   可以在目标页面中获取参数值使用。
     * 2.在目标页面中，可以使用 ${param.参数名} 参数舒获取参数的值
     */
    @RequestMapping("/redirect.do")
    public ModelAndView doRedirect(String name,Integer age){
        System.out.println("doRedirect , name = "+name+" , age = "+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //重定向不能访问 /WEB-INF
        mv.setViewName("redirect:/other.jsp");
        return mv;
    }
}
