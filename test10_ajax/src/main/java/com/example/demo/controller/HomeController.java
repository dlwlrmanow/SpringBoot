package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/member")
    public String member() {
        return "member";
    }

    @GetMapping("/findid")
    public String findId() {
        return "findid";
    }

//    @GetMapping("/member/findid")
//    public String memberFind() {
//        return "findid";
//    }
}
