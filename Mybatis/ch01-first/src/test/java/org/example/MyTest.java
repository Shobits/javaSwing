package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    @Test
    public void testSelectStuById() throws IOException {
        //调用Mybatis某个对象的方法，执行 mapper 文件中的sql语句
        //mybatis核心类，SqlSessionFactory

        //1. 定义 mybatis 主配置文件的位置，从类路径开始的相对路径
        String config = "Mybatis.xml";
        //2. 读取主配置文件，使用 mybatis 中 resource类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3. 创建 SqlSessionFactory对象， 使用 SqlSessionFactory Builder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        //4. 获取SqlSession
        SqlSession session = factory.openSession();

        //5. 指定要执行的 sql 语句的 id
        String sqlId = "org.example.Dao.StudentDao" + "." + "selectStuById";

        //6. 通过 SqlSession 的方法，执行 sql 语句
        Student student = session.selectOne(sqlId, 6);

        System.out.println("查询的一个同学：" + student);

        //7. 关闭 SqlSession对象
        session.close();
    }

    @Test
    public void testAddStu() throws IOException {
        String config = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        String sqlId = "org.example.Dao.StudentDao" + "." + "insertStu";

        Student student = new Student();
        student.setName("苏添昊");
        student.setAge(20);
        int rows = session.insert(sqlId, student);

        System.out.println("添加一个同学：" + student + ", rows = " + rows);
        //mybatis默认执行sql语句是手工提交事务模式，在做insert,update,delete后需要提交事务
        session.commit();

        session.close();
    }

    @Test
    public void testAddStu1() throws IOException {
        String config = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession(true);

        String sqlId = "org.example.Dao.StudentDao" + "." + "insertStu";

        Student student = new Student();
        student.setName("林瑞辰");
        student.setAge(20);
        int rows = session.insert(sqlId, student);

        System.out.println("添加一个同学：" + student + ", rows = " + rows);

        session.close();
    }
}
