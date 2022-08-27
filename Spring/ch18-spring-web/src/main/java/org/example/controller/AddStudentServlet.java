package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入addStudent");
        String stuName = request.getParameter("name");
        String stuAge = request.getParameter("age");
        System.out.println("获取成功");
        //调用Service
        //使用spring提供的工具方法，获取容器对象
        ServletContext sc = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);

        System.out.println("在Servlet中创建的对象容器===" + ctx);

        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setStuName(stuName);
        student.setStuAge(Integer.valueOf(stuAge));

        service.addStudent(student);
        System.out.println("添加成功");
        //给用户显示请求结果
        request.getRequestDispatcher("/show.jsp").forward(request, response);
        System.out.println("事务完成");
    }
}
