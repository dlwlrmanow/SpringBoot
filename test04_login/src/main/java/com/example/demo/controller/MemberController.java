package com.example.demo.controller;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired private MemberService service;

    @GetMapping("/member/join")
    public String join(@ModelAttribute Member member) { //맨 처음 폼으로 갈 때 th:object="${member}"에 member가 없어서 오류
        return "member/join";
    }

    @PostMapping("/member/join")
    public String insert(@ModelAttribute Member member, BindingResult bindingResult, Model model) { // 2. 유효성 체크: BindResult(Model 객체 바로 뒤에) 추가
        if(!StringUtils.hasText(member.getId())){ // id란이 공백이면 
            // bindingResult.addError new FieldError("객체명", "필드명", "에러메세지")
            bindingResult.addError(new FieldError("member", "id", "아이디를 입력하세요.")); // 에러담기
        }
        if(!StringUtils.hasText(member.getPwd())){
            bindingResult.addError(new FieldError("member", "pwd", "비밀번호를 입력하세요."));
        }
        // 나이 1 ~ 150까지
        if( (Integer) member.getAge() < 1 || (Integer) member.getAge() > 150 ){
            bindingResult.addError(new FieldError("member", "age", "나이를 확인해주세요"));
        }
        if(bindingResult.hasErrors()) { // 에러가 있으면 join으로 보내기
            return "member/join";
        }
        try {
            service.insert(member);
            model.addAttribute("result", "가입완료");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("result", "회원가입 실패: " + e.getMessage());
        }
        return "member/result";
    }
}
