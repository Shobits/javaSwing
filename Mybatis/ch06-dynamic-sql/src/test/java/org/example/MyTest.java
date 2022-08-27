package org.example;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void test03() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Integer> idList = new ArrayList<>();
        //idList.add(1);
        //idList.add(2);
        //idList.add(3);
        idList = null;
        List<Student> students = dao.selectForEachOne(idList);

        students.forEach(stuL -> System.out.println("students == " + students));

        //3. 关闭
        session.close();
    }

    @Test
    public void test04() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> stu = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1);

        Student s2 = new Student();
        s1.setId(2);

        Student s3 = new Student();
        s1.setId(3);

        stu.add(s1);
        stu.add(s2);
        stu.add(s3);

        List<Student> students = dao.selectForEachTwo(stu);

        students.forEach(stuL -> System.out.println("students == " + students));

        //3. 关闭
        session.close();
    }

    @Test
    public void test01() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("石欣源");
        stu.setAge(20);
        List<Student> stuList = dao.selectIf(stu);
        stuList.forEach(stuL -> System.out.println("stuL == " + stuL));
        //3. 关闭
        session.close();
    }

    @Test
    public void test02() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("石欣源");
        stu.setAge(20);
        List<Student> stuList = dao.selectWhere(stu);
        stuList.forEach(stuL -> System.out.println("stuL == " + stuL));
        //3. 关闭
        session.close();
    }

    @Test
    public void testPageHelper() {
        //1. 获取 SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //2. 获取 dao 的代理
        StudentDao dao = session.getMapper(StudentDao.class);

        //调用PageHelper
        PageHelper.startPage(2, 3);
        List<Student> students = dao.selectAllStudent();

        students.forEach(stu -> System.out.println("stu == " + stu));

        //3. 关闭
        session.close();
    }
}
