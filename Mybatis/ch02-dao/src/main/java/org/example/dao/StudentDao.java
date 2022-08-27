package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    Student selectStuById(@Param("StuId") Integer id);

    List<Student> selectAllStu();

    int insertStudent(Student student);
}
