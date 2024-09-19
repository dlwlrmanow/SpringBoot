package com.example.demo.config;

import com.example.demo.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    CustomUserDetailsService service;

    @Bean // PasswordEncoder객체를 생성해 스프링빈으로 등록하기
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(csrfConfigure -> csrfConfigure.disable()) // csrf토큰 사용하지 않기
                .authorizeRequests(authz -> authz
                .requestMatchers("/member/**").authenticated() // url 있는 곳 인증 필요
//                .requestMatchers("/admin/**").authenticated()
                .requestMatchers("/admin/**").hasAuthority("ADMIN") // "ADMIN"이라는 권한이 있는지 검사
                .anyRequest().permitAll() // 나머지 요청은 인증 없이 모두 접근 가능
        )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // login Page
                        .loginProcessingUrl("/loginOk") // login 페이지의 action 속성 form에서 처리되면 loginOk로 // url 주지 않으면 기본값 /login
                        .defaultSuccessUrl("/", true) // true는 항상 기본 URL로 리다이렉트되도록 설정
                        .permitAll()
                )
                .logout((logoutConfig) -> // post로 넘겨야한다
                        logoutConfig.logoutSuccessUrl("/") // 로그인 성공시 홈으로 url주기
                )
                .userDetailsService(service);
        return http.build();
    }
}
