package com.example.config;

import com.example.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

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

    //注册 filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //使用框架中的过滤器类
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        //指定使用编码的方式
        filter.setEncoding("UTF-8");
        //指定 request，response 都使用 encoding 的值
        filter.setForceEncoding(true);
        //指定过滤的地址
        bean.setFilter(filter);
        bean.addUrlPatterns("/*");
        return bean;
    }
}
