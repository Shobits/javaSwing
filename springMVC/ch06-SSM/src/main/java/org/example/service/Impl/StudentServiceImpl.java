package org.example.service.Impl;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <bean>
 * @Service
 */
@Service
public class StudentServiceImpl implements StudentService {
    /**
     * dao 是一个引用类型。StudentDao类型的对象实在 spring 的配置文件中创建的对象
     * 引用类型的自动注入 @Autowired, @Resource
     */
    @Autowired
    private StudentDao dao;

    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);
        return rows;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> studentList = dao.selectStudent();
        return studentList;
    }
}
