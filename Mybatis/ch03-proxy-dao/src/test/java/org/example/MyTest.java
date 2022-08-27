package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectStuById(5);
        System.out.println("查询结果 = " + student);
        //3. 关闭
        session.close();
    }

    @Test
    public void test02() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        System.out.println("dao == " + dao.getClass().getName());
        List<Student> students = dao.selectAllStu();
        System.out.println("查询结果 = " + students);
        //3. 关闭
        session.close();

    }
}
