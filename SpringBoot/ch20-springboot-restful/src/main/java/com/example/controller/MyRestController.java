package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    //学习注解的使用

    //查询 id = 1001 的学生

    /**
     * @PathVariable（路径变量）: 获取 url 中的数据
     * 属性：value 路径变量名
     * 位置：控制器方法形参的前面
     * {stuId} 定义路径变量
     */
    //@GetMapping("/student/{stuId}")
    //public String queryStudent(@PathVariable("stuId") Integer studentId) {
    //    return "查询学生 stuId = " + studentId;
    //}

    /**
     * 创建资源 Post请求方式
     */
    //@PostMapping("/student/{name}/{age}")
    //public String createStudent(@PathVariable("name") String name,
    //                            @PathVariable("age") Integer age
    //) {
    //    return "添加学生 student: name = " + name + "# age = " + age;
    //}

    /**
     * 更新资源
     */
    //@PutMapping("/student/{id}/{age}")
    //public String modifyStudent(@PathVariable("id") Integer id,
    //                            @PathVariable("age") Integer age
    //) {
    //    return "更新学生 执行put方法 student: id = " + id + "#age = " + age;
    //}

    /**
     * 删除资源
     */
    //@DeleteMapping("/student/{id}")
    //public String removeStudentById(@PathVariable("id") Integer id) {
    //    return "删除学生 执行 delete 操作 student: id = " + id;
    //}

    @PutMapping("/student/test")
    public String test01() {
        return "执行student/test，请求方式 put";
    }

    @DeleteMapping("/student/test")
    public String test02() {
        return "执行student/test，请求方式 delete";
    }
}
