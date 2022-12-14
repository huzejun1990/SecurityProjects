package com.dream.web.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by huzejun
 * on 2019/4/2 17:19
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter 耗时:" + (new Date().getTime() - start));
        System.out.println("time filter finish");
    }




    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }
}
