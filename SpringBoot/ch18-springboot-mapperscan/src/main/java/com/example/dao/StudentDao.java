package com.example.dao;

import com.example.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Mapper: 告诉 MyBatis 这是 dao接口，创建此接口的代理对象。
 * 位置：在类的上面
 */
public interface StudentDao {
    public Student selectStuById(@Param("stuId") Integer id);
}
