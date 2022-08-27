package org.example.dao;

import org.example.domain.Student;

public interface StudentDao {
    Student selectStuById(Integer stuId);

}
