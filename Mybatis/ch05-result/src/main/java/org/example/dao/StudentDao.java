package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.CustomObject;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectStuById(Integer stuId);

    CustomObject selectById(@Param("stuId") Integer id);

    long countStudent();

    Map<Object, Object> selectMap(@Param("stuId") Integer id);

    List<Student> selectLickOne(@Param("name") String name);
    List<Student> selectLickTwo(@Param("name") String name);
}
