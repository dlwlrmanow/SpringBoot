package com.example.demo.dto;

import com.example.demo.entity.Fileinfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileinfoDto {
	private Long filenum;
	private String writer;
	private String title;
	private String content;
	private String orgfilename;
	private String savefilename;
	private long filesize;	
	
	public FileinfoDto(Fileinfo info) {
		this.filenum=info.getFilenum();
		this.writer=info.getWriter();
		this.title=info.getTitle();
		this.content=info.getContent();
		this.orgfilename=info.getOrgfilename();
		this.savefilename=info.getSavefilename();
		this.filesize=info.getFilesize();
	}	
	public Fileinfo toEntity() {
		Fileinfo info=Fileinfo.builder()
				.filenum(filenum)
				.writer(writer)
				.title(title)
				.content(content)
				.orgfilename(orgfilename)
				.savefilename(savefilename)
				.filesize(filesize)
				.build();
		return info;
	}
}