package org.example.Dao;

import org.example.domain.Student;

public interface StudentDao {
    //查询一个学生
    Student selectStuById(Integer id);

    //添加学生
    //返回值 int 表示本次操作影响的数据库行数
    int insertStu(Student student);
}
