package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
    @Autowired private MemberService service;
    @GetMapping("/member/mypage")
    public String mypageForm(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            String id = (String)session.getAttribute("id");
            if(id != null) {
                Member m = service.select(id);
                model.addAttribute("member", m);
                return "member/mypage";
            }
        }
        return "redirect:/member/login";
    }

}
