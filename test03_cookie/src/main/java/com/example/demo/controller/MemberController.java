package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MemberController {

    @GetMapping("/member/item")
    public String item(Model model, HttpServletRequest req) { // 쿠키 검사할 때는 HttpServletRequest req
        ArrayList<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        model.addAttribute("list", list);

        // cookie에 id가 존재하는 지 검사 HttpServletRequest req는 배열로 받아온다.
        Cookie[] cookies = req.getCookies();
        if(cookies != null) { // 최초 요청시에는 null 두번째 요청부터 쿠키 생성된다.
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("id")) {
                    model.addAttribute("id", cookie.getValue());
                }
            }
            return "member/login"; // 로그인정보(쿠키)가 없으면 로그인 페이지로 이동
        }
        return "member/item";
    }
}
