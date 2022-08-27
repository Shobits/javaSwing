package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.example.vo.CustomObject;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
        CustomObject student = dao.selectById(5);
        System.out.println("CustomObject = " + student);
        //3. 关闭
        session.close();
    }

    @Test
    public void test03() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        long nums = dao.countStudent();
        System.out.println("nums = " + nums);
        //3. 关闭
        session.close();
    }

    @Test
    public void test04() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMap(6);
        System.out.println("map = " + map);
        //3. 关闭
        session.close();

        System.out.println("name = " + map.get("name") + " , id = " + map.get("id"));
    }

    @Test
    public void test05() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        String name = "宋%";
        List<Student> studentList = dao.selectLickOne(name);
        studentList.forEach(stu -> System.out.println("stu == " + stu));
        //3. 关闭
        session.close();
    }

    @Test
    public void test06() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        String name = "宋%";
        List<Student> studentList = dao.selectLickTwo(name);
        studentList.forEach(stu -> System.out.println("stu == " + stu));
        //3. 关闭
        session.close();
    }
}
