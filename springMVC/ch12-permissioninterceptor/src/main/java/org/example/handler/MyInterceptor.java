package org.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("===== MyInterceptor 拦截器11111的 preHandle =====");
        String username = "";
        //获取登录信息
        Object attr = request.getSession().getAttribute("username");
        if (attr != null) {
            username = (String) attr;
        }

        //判断账号
        if ("zhangsan".equals(username)) {
            return true;
        } else {
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("===== MyInterceptor 拦截器11111的 postHandle =====");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("===== MyInterceptor 拦截器11111的 afterCompletion =====");

    }
}
