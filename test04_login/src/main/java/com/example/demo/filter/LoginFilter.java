package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

//@WebFilter - 사용시에 필터를 여러개 걸어주면 순서를 지정할 수 없음
public class LoginFilter implements Filter {
    String whiteList[] = {"/", "/member/login", "/member/logout", "/member/join", "/css"}; // 로그인이 필요하지 않은 페이지 목록
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI(); // 요청 uri값 얻어오기
        HttpSession session = req.getSession(false); // session값 얻어오기
        if(isLoginCheck(uri)){ // 로그인한 사용자만 볼 수 있는 페이지
            if(session == null || session.getAttribute("id") == null){ // 근데 로그인이 안되어있음
                resp.sendRedirect("/member/login"); // 로그인하도록
                return;
            }
        }
        chain.doFilter(request, response); // 현재 필터가 요청을 처리한 후, 필터 체인에 등록된 다음 필터나 서블릿으로 요청과 응답을 넘겨주는 역할
    }
    private boolean isLoginCheck(String requestURI){ // login되어있는지 불린값으로 체크
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI); // whiteList의 목록과 사용자가 요청한 uri가 일치하는지 확인
    }
}
