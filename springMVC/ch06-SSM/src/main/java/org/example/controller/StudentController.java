package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     * 声明一个引用类型，调用引用类型的业务方法
     * 引用类型的自动注入 @Autowired, @Resource
     */
    @Resource
    private StudentService service;

    //添加学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();
        int rows = service.addStudent(student);
        String msg = "注册失败！";
        if (rows > 0) {//注册成功 给用户成功的数据和视图
            msg = "注册成功！";
        }
        mv.addObject("msg", "[" + student.getName() + "] , " + msg);
        mv.setViewName("result");
        return mv;
    }

    //浏览学生
    @RequestMapping(value = "/queryStudent.do")
    @ResponseBody //结果转为 JSON 数据
    public List<Student> queryStudent() {
        List<Student> students = service.queryStudent();
        return students;
    }
}
