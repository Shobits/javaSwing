package com.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {
    /**
     * 引用远程服务，把创建好的远程对象，注入给 StudentService
     */

    //@DubboReference(interfaceClass = StudentService.class, version = "1.0")

    /**
     * 没有使用 interfaceClass ，默认的就是 引用类型的 数据类型
     */
    @DubboReference(version = "1.0")
    private StudentService service;

    @GetMapping("/query")
    public String queryStudent(Integer id) {
        Student student = service.queryStudent(id);
        return "调用远程接口 student = " + student;
    }
}
