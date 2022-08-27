package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    /**
     * @param name
     * @param age
     * @return org.springframework.web.servlet.ModelAndView
     * @author Shu
     * @description //TODO 控制器返回String，表示逻辑名称，需要项目找中配置视图解析器
     * @date 15:32 2022/8/7
     */
    @RequestMapping(value = "/return-string-view1.do")
    public String doReturnStringView1(HttpServletRequest request, String name, Integer age) {
        System.out.println("执行了 MyController 的 doReturnStringView1 方法，name = " + name + " age = " + age);
        //处理数据，
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);

        //返回结果，forward，转发到show.jsp
        return "show";
    }

    /**
     * 控制器方法返回String，表示完整视图路径，项目中不能配置视图解析器
     */
    @RequestMapping(value = "/return-string-view2.do")
    public String doReturnStringView2(HttpServletRequest request, String name, Integer age) {
        System.out.println("执行了 MyController 的 doReturnStringView1 方法，name = " + name + " age = " + age);
        //处理数据，
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);

        //返回结果，forward，转发到show.jsp
        return "/WEB-INF/view/show.jsp";
    }

    /**
     * 控制器方法返回的是void，相应ajax请求，使用HttpServletResponse输出数据
     */
    @RequestMapping("/return-void-ajax.do")
    public void returnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("处理 void 返回类型， name = " + name + ", age = " + age);
        //调用 service 得到结果对象
        Student student = new Student();
        student.setName(name + "同学");
        student.setAge(age);

        //对象转为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);
        System.out.println("服务器端将独享转换为 json === " + json);

        //输出json, 响应ajax
        response.setContentType("application/json;charset-UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /**
     * 控制器方法返回 Student -- json
     * application/json;charset=UTF-8
     * <p>
     * 框架的处理模式：
     * 1. 根据控制器的返回值类型，找到 HttpMessageConverter 接口的实现类。
     * 最后找到的是 MappingJackson2HttpMessageConverter，
     * 2. 使用实现类 MappingJackson2HttpMessageConverter，执行他的 write() 方法，
     * 把 student 对象转为 json 格式的数据
     * 3. 框架使用 @ResponseBody 注解，把 2 中 json 输出给浏览器。
     * <p>
     * 设置的 contentType-type:application/json;charset=UTF-8
     */
    @RequestMapping("doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name, Integer age) {
        System.out.println("控制器方法返回自定义对象Student，转为json =" + name + " == " + age);

        Student student = new Student();
        student.setName(name + "同学");
        student.setAge(age);

        return student;
    }

    /**
     * 控制器方法返回的是 List<Student> -- json array
     */

    @RequestMapping("/doListJsonArray.do")
    @ResponseBody
    public List<Student> doAjaxJsonArray(String name, Integer age) {
        System.out.println("控制器方法返回自定义对象 List<Student>，转为jsonArray =" + name + " == " + age);

        Student student = new Student();
        student.setName("张三同学");
        student.setAge(20);

        Student student1 = new Student();
        student1.setName("王五同学");
        student1.setAge(21);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student);

        return studentList;
    }

    /**
     * 控制器方法返回String--数据
     *
     * 区分返回值 String 是数据还是视图
     * 1. 方法上面有 @ResponseBody 注解是数据
     * 2. 没有 @ResponseBody 就是视图
     *
     * Content-Type: text/plain;charset=ISO-8859-1
     *
     * 解决中文，需要使用 @RequestMapping 的 produces 属性
     * produces 属性：指定 context-type 的值
     *
     * 框架处理 String 返回值
     * 1. 框架使用的 StringHttpMessageConverter
     * 2. StringHttpMessageConverter 使用的是 text/plain;charset=ISO-8859-1
     */
    @RequestMapping(value = "/doStringData.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doStringData(String name, Integer age) {
        System.out.println("控制器方法返回一个string,是数据");
        return "Hello SpringMVC注解式开发";
    }
}
