package com.FilterExampleProgram.filterprogram.Config;

import com.FilterExampleProgram.filterprogram.Filter.AuthorizationFilter;
import com.FilterExampleProgram.filterprogram.Filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilterRegistration() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();

        //Register the custom filter
        registrationBean.setFilter(new LoggingFilter());

        //Apply the filter to specific URL patterns
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilter() {
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthorizationFilter());

        // Apply only to student-related endpoints
        registrationBean.addUrlPatterns("/students/*");

        // Executes after LoggingFilter
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
