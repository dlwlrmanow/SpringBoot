package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }
    @PostMapping("/member/login")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletResponse resp) {
        if(id.equals("hello") && pwd.equals("1111")) {
            Cookie cookie = new Cookie("id", id); // cookie 생성(key - value)
            cookie.setMaxAge(60 * 3); // cookie 유지 시간 설정 (초단위) : 60*3 = 3분: 브라우저를 닫았다 켜도 3분 유지 시켜놔서 로그인 상태 유지
            // 위의 유지시간 코드가 없음녀 쿠키는 웹브라우저를 닫을 때까지 유지
            resp.addCookie(cookie); // 쿠키를 응답객체에 담기 - 유지시간: 웹브라우저 닫을 때까지
            return "redirect:/"; // 일치하면 home으로
        }
        return "member/login";
    }
    @GetMapping("/member/logout")
    public String logout(HttpServletResponse resp) {
        // cookie 삭제 - 유지 시간을 0으로 설정 후 응답객체에 보내기
        Cookie cookie = new Cookie("id", null); // value는 의미없음 name값만 동일하면 된다.
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        return "redirect:/";
    }
}
