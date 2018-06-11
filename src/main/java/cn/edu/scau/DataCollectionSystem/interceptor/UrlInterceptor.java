package cn.edu.scau.DataCollectionSystem.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UrlInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(UrlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.info("Time - " + time.format(LocalDateTime.now()));
        log.info("IP - " + request.getRemoteAddr());
        log.info("URL - " + request.getRequestURL());
        log.info("Method - " + request.getMethod());
        log.info("\r\n");
        return true;
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
