package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/user/join")
    public String joinForm() {
        return "user/join";
    }

    @PostMapping("/user/join")
    public String join(User user) {
        service.save(user);
        return "user/joinOk";
    }
}
