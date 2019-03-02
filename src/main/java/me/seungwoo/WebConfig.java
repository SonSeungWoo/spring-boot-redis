package me.seungwoo;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-02
 * Time: 13:47
 */
@Configuration
public class WebConfig implements WebMvcConfigurer, WebMvcRegistrations {

    @Bean
    public FilterRegistrationBean<LogFilter> myFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new LogFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}


