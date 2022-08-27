package com.example.config;

import com.example.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSystemConfig {
    //注册 servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean();

        bean.setServlet(new MyServlet());

        bean.addUrlMappings("/myServlet");
        return bean;
    }
}
