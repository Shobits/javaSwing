package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;

public interface StudentDao {
    int insertStudent(Student student);
    Student selectById(@Param("studentId") Integer id);
}
