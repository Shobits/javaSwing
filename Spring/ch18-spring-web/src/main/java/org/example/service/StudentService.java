package org.example.service;

import org.example.domain.Student;

public interface StudentService {
    int addStudent(Student student);
    Student findStudentById(Integer id);//query search getId
}
