package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {
    @Resource
    private StudentService service;

    @RequestMapping("/student/query")
    @ResponseBody
    public String queryStudent(Integer id) {
        Student student = service.queryStudent(id);
        return student.toString();
    }
}
