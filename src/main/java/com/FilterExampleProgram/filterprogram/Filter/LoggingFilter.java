package com.FilterExampleProgram.filterprogram.Filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response , FilterChain chain) throws IOException , ServletException{
        System.out.println("request Received" + request.getRemoteAddr());
        chain.doFilter(request,response);  //proceeds with next filter
        System.out.println("Response Sent");
    }
}
