package com.example.config;

import com.example.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfig {
    //定义方法，注册 Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        //ServletRegistrationBean(T servlet, String... urlMappings)
        //第一个参数是 servlet对象， 第二个参数是 url地址
        //ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(), "/myServlet");

        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/myServlet", "/login");
        return bean;
    }

}
