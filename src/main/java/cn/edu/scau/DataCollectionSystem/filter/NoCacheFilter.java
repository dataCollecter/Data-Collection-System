package cn.edu.scau.DataCollectionSystem.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException{
        //设置禁止缓存的消息头
        ((HttpServletResponse)response).setHeader("Pragma","No-cache");
        ((HttpServletResponse)response).setHeader("Cache-Control","no-cache");
        ((HttpServletResponse)response).setHeader("Expires","0");//禁止缓存

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
