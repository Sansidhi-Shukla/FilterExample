package com.FilterExampleProgram.filterprogram.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class AuthorizationFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response , FilterChain chain) throws IOException, ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request ;
        String role = httpRequest.getHeader("role") ;

        if("Student".equals(role)){
            System.out.println("AuthorizationFilter - role Authorised" + role);
            chain.doFilter(request,response);
        }
        else{
            System.out.println("AuthorizationFilter - Unauthorized access attempt.");
            response.getWriter().write("Unauthorized");

        }
    }
}
