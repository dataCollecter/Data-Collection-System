package com.scau.DataCollectionSystem.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println(request.getRequestURI());
//        System.out.println(request.getSession().getAttribute("user"));
        // 获取访问的url
        String url = request.getRequestURI();
//        if(url.equals("/DataCollectionSystem/WEB-INF/content/logout.html"))
//            return true;

        if(url.equals("/DataCollectionSystem/"))
            return true;
//        if(url.contains("/logout"))
//            return true;
        if(url.contains("/index"))
            return true;
        if(url.contains("/redirect"))
            return true;
        if(url.contains("/static"))
            return true;
        //如果是登录
        if(url.contains("/login"))
            return true;
        //判断是否已登录
        HttpSession seesion = request.getSession();
        if(seesion.getAttribute("user") != null)
            return true;

        System.out.println("enter");
        /*若不满足以上，拦截，跳转到首页*/
        request.getRequestDispatcher("/WEB-INF/content/redirect.html").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView mv) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) {
        // TODO Auto-generated method stub
    }
}
