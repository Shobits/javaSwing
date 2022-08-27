package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId");

        //String config = "spring-beans.xml";
        //ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //使用监听器已经创建好的容器对象，从servletContext作用域获取
        WebApplicationContext ctx = null;
        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        ServletContext sc = getServletContext(); //ServletContext，servlet中的方法
        //ServletContext sc = request.getServletContext(); //HttpServletRequest对象的方法

        Object attr = sc.getAttribute(key);
        if (attr != null) {
            ctx = (WebApplicationContext) attr;
        }

        System.out.println("在servlet中创建的对象容器 === " + ctx);

        StudentService service = (StudentService) ctx.getBean("studentService");

        Student student = service.findStudentById(Integer.valueOf(stuId));

        System.out.println("student对象 === " + student);

        request.setAttribute("stu", student);
        request.getRequestDispatcher("/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
