package com.example.demo.config;

import com.example.demo.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    // 메소드 이름이 @bean객체의 이름
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<>(); // 서블릿 필터를 Spring의 컨텍스트에 등록
        bean.setFilter(new LoginFilter()); // 필터 등록
        bean.setOrder(1); // 필터 순서 설정
        bean.addUrlPatterns("/*"); //필터가 적용될 URL 패턴을 설정 "/*": 모든 요청 경로에 대해 필터가 적용
        return bean;
    }
}
