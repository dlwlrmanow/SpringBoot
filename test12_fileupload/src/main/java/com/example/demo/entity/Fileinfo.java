package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Fileinfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long filenum;
	private String writer;
	private String title;
	private String content;
	private String orgfilename;
	private String savefilename;
	private long filesize;

}










