package com.example.demo.controller;

import com.example.demo.dto.MovieDto;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired private MovieService service;

    @GetMapping("/")
    public String home(Model model) {
        List<MovieDto> list = service.movieList();
        model.addAttribute("list", list);
        return "home";
    }
}
