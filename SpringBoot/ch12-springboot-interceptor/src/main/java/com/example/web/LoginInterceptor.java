package com.example.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param handler  被拦截器的控制器对象
     * @return boolean
     * true: 请求能被controller 处理
     * false: 请求被拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("执行了 LoginInterceptor 的 preHandle");
        return true;
    }
}
