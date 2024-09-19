package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentsDto;
import com.example.demo.dto.PageResultDto;
import com.example.demo.service.CommentsService;

@RestController
@RequestMapping("/comm")
public class CommentsController {
	@Autowired private CommentsService commentsService;
	
	@GetMapping("/list/{mnum}/{page}") //  list/1/0
	public ResponseEntity<PageResultDto>  list(@PathVariable("mnum")long mnum,
			                               @PathVariable("page")int page){

		PageRequest pageable=PageRequest.of(page,3,Sort.by("cnum").descending());
		PageResultDto pageResult = commentsService.list(mnum,pageable);
		return new ResponseEntity<PageResultDto>(pageResult, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(CommentsDto dto){
		String result="success";
		try {
			commentsService.save(dto);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			result="fail";
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
}
