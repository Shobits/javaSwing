package org.example.service.Impl;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao;

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);
        return rows;
    }

    @Override
    public Student findStudentById(Integer id) {
        Student studentList = dao.selectById(id);
        return studentList;
    }
}
