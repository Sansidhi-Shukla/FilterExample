package com.FilterExampleProgram.filterprogram.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class IPWhitelistFilter extends HttpFilter {
    private static final List<String> ALLOWED_IPS = List.of("0:0:0:0:0:0:0:1"); // Example IPs

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String remoteIp = request.getRemoteAddr();

        if (ALLOWED_IPS.contains(remoteIp)) {
            System.out.println("Request from allowed IP: " + remoteIp);
            chain.doFilter(request, response); // Proceed if IP is allowed
        } else {
            System.out.println("Request from blocked IP: " + remoteIp);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Deny access
            response.getWriter().write("Forbidden: Your IP is not allowed" + remoteIp);
        }
    }
}
