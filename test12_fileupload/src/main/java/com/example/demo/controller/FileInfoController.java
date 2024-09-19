package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileInfoController {
    @Autowired
    private FileService service;

    @GetMapping("/file/info")
    public String fileinfo(@RequestParam("filenum") long filenum, Model model) {
        model.addAttribute("dto", service.select(filenum));
        return "file/info";
    }
}
