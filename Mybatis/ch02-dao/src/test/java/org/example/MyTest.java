package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 去指定 sqlId
        String sqlId = "org.example.dao.StudentDao.selectStuById";
        //3. 执行 SqlSession 的方法,表示执行 sql 语句
        Student student = session.selectOne(sqlId, 1);
        System.out.println("查询结果 == " + student);
        session.close();
    }

    @Test
    public void test02() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 去指定 sqlId
        String sqlId = "org.example.dao.StudentDao.selectAllStu";
        //3. 执行 SqlSession 的方法,表示执行 sql 语句
        List<Student> List = session.selectList(sqlId);
        for (Student stu : List) {
            System.out.println("查询结果 == " + stu.getName());
        }
        session.close();
    }

    @Test
    public void test03() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 去指定 sqlId
        String sqlId = "org.example.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setName("石欣源");
        student.setAge(21);
        //3. 执行 SqlSession 的方法,表示执行 sql 语句
        session.insert(sqlId, student);
        session.commit();
        session.close();
    }
}
