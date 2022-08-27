package org.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * preHandle: 预处理方法
     * 参数：
     * Object handler：被拦截的控制器对象（MyController）
     * 返回值： Boolean
     * true: 请求是正确的，是可以被 controller 处理的
     * ===== MyInterceptor 拦截器的 preHandle =====
     * doSome 方法
     * ===== MyInterceptor 拦截器的 postHandle =====
     * ===== MyInterceptor 拦截器的 afterCompletion =====
     * false: 请求不正确，不能被执行
     * ===== MyInterceptor 拦截器的 preHandle =====
     * 特点：
     * 1. 预处理方法的执行时间：在控制器方法之前先执行的
     * 2. 可以对请求做处理。嗯可以做登录的检查，权限的判断，统计数据等等
     * 3. 决定请求是否执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("===== MyInterceptor 拦截器的 preHandle =====");
        //提示
        //request.getRequestDispatcher("/tips.jsp").forward(request,response);
        //response.sendRedirect("");
        return true;
    }

    /**
     * postHandle: 后处理方法
     * 参数：
     * Object handler: 被拦截的控制器对象(MyController)
     * ModelAndView mv: 控制器方法的返回值（请求执行的结果）
     * <p>
     * 特点：
     * 1. 在控制器方法之后执行
     * 2. 能获取到控制器方法的执行结果，可以修改原来的执行结果
     * 可以修改数据，也可以修改视图
     * 3. 看作对请求的二次处理
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("===== MyInterceptor 拦截器的 postHandle =====");
        //对请求做二次处理
        if (mv != null) {
            //修改数据
            mv.addObject("mydata", new Date());
            //修改视图
            mv.setViewName("other");
        }
    }

    /**
     * afterCompletion: 最后执行的方法
     * 参数：
     * Object handler: 被拦截的控制器（MyController）
     * Exception ex：异常对象
     * <p>
     * 特点：
     * 1. 在请求处理完成后执行的，
     * 请求处理完成的标志是，视图处理完成，对视图执行 forward 操作后。
     * 2. 可以做程序最后要做的工作，释放内存，清楚临时变量
     * 3. 方法执行的条件：
     * 1) 当前的拦截器他的 preHandle() 方法必须执行
     * 2）preHandle() 必须返回 true
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("===== MyInterceptor 拦截器的 afterCompletion =====");

        // 获取数据
        HttpSession session = request.getSession();
        Object attr = session.getAttribute("attr");
        System.out.println("attr = " + attr);

        //删除数据
        session.removeAttribute("attr");

        attr = session.getAttribute("attr");
        System.out.println("再次检查数据 attr == " + attr);
    }
}
