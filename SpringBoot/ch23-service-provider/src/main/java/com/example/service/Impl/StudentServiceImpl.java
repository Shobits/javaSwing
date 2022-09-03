package com.example.service.Impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.model.Student;
import org.example.service.StudentService;

/**
 * 使用 dubbo 中的注解暴露服务
 */
//@Component // 可加可不加
@DubboService(
        interfaceClass = StudentService.class,
        version = "1.0",
        timeout = 5000)
public class StudentServiceImpl implements org.example.service.StudentService {
    @Override
    public Student queryStudent(Integer id) {
        Student student = new Student();
        if (1001 == id) {
            student.setId(1001);
            student.setName("1001-张三");
            student.setAge(20);
        } else if (1002 == id) {
            student.setId(1002);
            student.setName("1002-李四");
            student.setAge(21);
        }
        return student;
    }
}
