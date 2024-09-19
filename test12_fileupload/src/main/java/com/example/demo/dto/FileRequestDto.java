package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileRequestDto {
	private Long filenum;
	private String writer;
	private String title;
	private String content;
	private MultipartFile file1;
}
