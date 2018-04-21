package com.scau.DataCollectionSystem.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取访问的url
        String url = request.getRequestURI();


        if(url.equals("/DataCollectionSystem/WEB-INF/content/logout.html")) //以前留的坑
            return true;
        if(url.equals("/DataCollectionSystem/"))
            return true;
        if(url.contains("/index"))
            return true;
        if(url.contains("/redirect"))
            return true;
        if(url.contains("/interceptor"))
            return true;
        if(url.contains("/error"))
            return true;
        //如果是登录
        if(url.contains("/login"))
            return true;
        //判断是否已登录
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null)
            return true;

        log.warn("Intercept : " + url);
        /*若不满足以上，拦截，跳转到首页*/
        request.getRequestDispatcher("/view/interceptor").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView mv) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) {
    }
}
