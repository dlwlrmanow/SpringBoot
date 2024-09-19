package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("msg", "Hello World");
        return "home"; // file 이름으로 이동(home.html)
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/member")
    public String member() {
        return "member";
    }

    @GetMapping("/items")
    public String items() {
        return "items";
    }
}