package com.briup.web.filter;

import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author lining
 * @Date 2022/10/17
 */
@Log4j
@WebFilter("/*")
public class TestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //通过过滤逻辑，进行进行下一个过滤器判断
        log.debug("过滤器进行拦截");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
