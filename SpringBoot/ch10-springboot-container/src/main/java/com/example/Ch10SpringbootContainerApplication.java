package com.example;

import com.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ch10SpringbootContainerApplication {

    public static void main(String[] args) {
        //获取容器对象
        //ConfigurableApplicationContext ctx = SpringApplication.run(Ch10SpringbootContainerApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(Ch10SpringbootContainerApplication.class, args);

        //从容器中获取对象
        UserService UserService = (UserService) ctx.getBean("userService");

        UserService.sayHello("lisi");
    }

}
