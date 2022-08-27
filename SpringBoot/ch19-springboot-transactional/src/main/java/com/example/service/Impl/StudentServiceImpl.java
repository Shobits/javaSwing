package com.example.service.Impl;

import com.example.dao.StudentMapper;
import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * @Transactional: 表示方法有事物的支持
     *      默认：使用的是数据库的隔离级别，REQUIRED 传播行为，超时时间 -1
     *      抛出异常时回滚事务
     */
    @Transactional
    @Override
    public int addStudent(Student student) {
        System.out.println("业务方法的 addStudent");
        int rows = studentMapper.insert(student);
        System.out.println("执行 sql 语句");

        //抛出运行时异常，目的是回滚事务
        //int m = 10 / 0;
        return rows;
    }
}
