package com.example.demo.controller;

import com.example.demo.dto.FileinfoDto;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FileListController {
	@Autowired private FileService service;
	
	@GetMapping("/file/list")
	public String list(Model model) {
		List<FileinfoDto> list= service.list();
		model.addAttribute("list", list);
		return "file/list";
	}
	
}
