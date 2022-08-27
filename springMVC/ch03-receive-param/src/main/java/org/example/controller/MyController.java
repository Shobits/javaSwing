package org.example.controller;

import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class MyController {
    /**
     * @param name
     * @param age
     * @return org.springframework.web.servlet.ModelAndView
     * @author Shu
     * @description //TODO 逐个接受请求参数
     * 要求：请求中的参数名别控刺器方法的形参名一样。按名称对象接收清求参数
     * 参数接收：
     * 1.框架使request对象，接收参数
     * string name request.getParameter("name");
     * string age request.getParameter("age");
     * 2.在中央调度器的内部调用doProperParam方法时，按名称对象传递参数
     * doPropertyParam(name, Integer.valueOf(age))
     * 框架可以实现清求参数 string 到 int, long, float, double 等类型的转换。
     * @date 14:48 2022/8/6
     */
    @RequestMapping(value = "/receive-property.do")
    public ModelAndView doPropertyParam(String name, Integer age) {
        System.out.println("执行了 MyController 的 doPropertyParam 方法，name = " + name + " age = " + age);
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myName", name);
        mv.addObject("myAge", age);

        mv.setViewName("show");
        return mv;
    }

    /**
     * @param name
     * @param age
     * @return org.springframework.web.servlet.ModelAndView
     * @author Shu
     * @description //TODO
     * 逐个接收请求参数，请求中参数名和形参名不一样
     * @RequestParam : 解决名称不一样的问题
     * 属性：value 请求中参数的名称
     * required : Boolean类型的，默认是true
     * true: 请求中必须有此参数，没有报错。
     * false: 可以请求中没有参数，不报错。
     * 位置：在形参定义的前面
     * @date 15:01 2022/8/7
     */
    @RequestMapping(value = "/receive-param.do")
    public ModelAndView doReceiveParam(
            @RequestParam(value = "rname", required = false) String name,
            @RequestParam(value = "rage", required = false) Integer age) {
        System.out.println("执行了 MyController 的 doReceiveParam 方法，name = " + name + " age = " + age);
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myName", name);
        mv.addObject("myAge", age);

        mv.setViewName("show");
        return mv;
    }

    /**
     * @param
     * @return null
     * @author Shu
     * @description //TODO 使用对象接收请求中的参数
     * 要求：参数和Java对象的属性名一样。
     * Java类需要有一个无参数构造方法，属性有set方法
     * @date 15:14 2022/8/7
     */
    @RequestMapping("/receive-object.do")
    public ModelAndView doReceiveObject(Student student) {
        System.out.println("MyController 的方法，doReceiveObject = " + student);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", student.getName());
        mv.addObject("myAge", student.getAge());
        mv.setViewName("show");
        return mv;
    }

}
