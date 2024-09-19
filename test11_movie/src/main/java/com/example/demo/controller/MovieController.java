package com.example.demo.controller;

import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {
    @Autowired private MovieService movieService;

    @GetMapping("/movie/detail")
    public String detail(@RequestParam("mnum") long mnum, Model model) {
        model.addAttribute("movie", movieService.select(mnum));
        return "movie/detail";
    }
}
