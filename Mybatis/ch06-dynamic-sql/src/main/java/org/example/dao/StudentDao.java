package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {

    //if
    List<Student> selectIf(Student student);

    List<Student> selectWhere(Student student);

    List<Student> selectForEachOne(List<Integer> idList);

    List<Student> selectForEachTwo(List<Student> studentList);

    List<Student> selectAllStudent();

}
