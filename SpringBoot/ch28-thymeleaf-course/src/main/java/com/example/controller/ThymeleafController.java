package com.example.controller;

import com.example.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    //标准变量表达式
    @GetMapping("/expression1")
    public String expression1(Model model) {
        //添加数据到 Model
        model.addAttribute("site", "www.baidu.com");
        model.addAttribute("myUser",
                new SysUser(1001, "李四", "男", 20));
        return "expression1";
    }

    //选择变量表达式
    @GetMapping("/expression2")
    public String expression2(Model model) {
        //添加数据到 Model
        model.addAttribute("site", "www.baidu.com");
        model.addAttribute("myUser",
                new SysUser(1001, "李四", "男", 20));
        return "expression2";
    }

    //连接表达式
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("userId", 1002);
        return "link";
    }

    //测试链接表达式的地址
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id) {
        return "queryAccount,参数 id = " + id;
    }

    //有两个参数的地址
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name, Integer age) {
        return "queryUser,参数 name = " + name + " age = " + age;
    }

    //使用模板的属性
    @GetMapping("/properties")
    public String useProperty(Model model) {
        model.addAttribute("methodAttr", "post");
        model.addAttribute("id", "2342");
        model.addAttribute("paraname", "name");
        model.addAttribute("uservalue", "lisi");
        model.addAttribute("textColor", "color:blue");
        return "html-property";

    }

    //循环List
    @GetMapping("/eachList")
    public String eachList(Model model) {
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser(1001, "张三", "m", 20));
        users.add(new SysUser(1002, "零四", "n", 21));
        users.add(new SysUser(1003, "王五", "n", 22));
        model.addAttribute("List", users);
        return "eachList";
    }

    //循环数组
    @GetMapping("/eachArray")
    public String eachArray(Model model) {
        SysUser[] userArray = new SysUser[3];
        userArray[0] = new SysUser(1001, "刘备", "m", 20);
        userArray[1] = new SysUser(1001, "关羽", "m", 21);
        userArray[2] = new SysUser(1001, "张飞", "m", 22);
        model.addAttribute("Array", userArray);
        return "eachArray";
    }

    //循环Map
    @GetMapping("/eachMap")
    public String eachMap(Model model) {
        Map<String, SysUser> map = new HashMap<>();
        map.put("user1", new SysUser(1001, "刘备", "m", 20));
        map.put("user2", new SysUser(1001, "关羽", "m", 21));
        map.put("user3", new SysUser(1001, "张飞", "m", 22));
        model.addAttribute("Map", map);

        Map<String, SysUser> map1 = new HashMap<>();
        map1.put("user4", new SysUser(2001, "刘备", "m", 20));
        map1.put("user5", new SysUser(2001, "关羽", "m", 21));
        map1.put("user6", new SysUser(2001, "张飞", "m", 22));

        HashMap<String, String> strMap = new HashMap<>();
        strMap.put("str1","Hello Spring");
        strMap.put("str2","Mybatis MySQL");
        model.addAttribute("strMap", strMap);

        List<Map<String,SysUser>> ListMap = new ArrayList<>();
        ListMap.add(map);
        ListMap.add(map1);
        model.addAttribute("LIstMap",ListMap);
        return "eachMap";
    }
}
