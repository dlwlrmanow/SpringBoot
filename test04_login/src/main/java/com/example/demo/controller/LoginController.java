package com.example.demo.controller;

import com.example.demo.dto.Login;
import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired private MemberService service;

    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(Login login, HttpServletRequest req) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", login.getId());
        map.put("pwd", login.getPwd());
        Member m = service.isMember(map); // 회원에 대한 정보 조회해서 m에 담기
        if(m == null){ // 회원이 아닌 경우
            return "member/login";
        } else{
            // session에 id 저장
            HttpSession session = req.getSession();
            System.out.println("session: " + session.getId());
//            session.setAttribute("id", m.getId());// session 객체 얻어오기
            if(session != null){
                session.setAttribute("id", m.getId()); // 아이디 저장하기
                System.out.println("id -> " + session.getAttribute("id"));
            }
            return "redirect:/";
        }
    }

    @GetMapping("/member/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate(); // 세션 삭제
        return "redirect:/";
    }
}
