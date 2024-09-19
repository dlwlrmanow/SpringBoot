package com.example.demo.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.FileRequestDto;
import com.example.demo.dto.FileinfoDto;
import com.example.demo.service.FileService;

@Controller
public class FileUpdateController {
    @Autowired FileService service;

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/file/update")
    public void updateForm(@RequestParam("filenum")long filenum,Model model) {
        model.addAttribute("dto", service.select(filenum));
    }
    @PostMapping("/file/update")
    public String update(FileRequestDto dto,Model model) {
        MultipartFile file1=dto.getFile1();
        try {
            FileinfoDto fileinfo=service.select(dto.getFilenum());
            if(!file1.isEmpty()) { 	//수정할 파일이 전송된 경우
                // 기존파일 삭제
                File f=new File(filePath + File.separator + fileinfo.getSavefilename());
                if(f.exists() && f.delete()) {
                    System.out.println("파일 삭제 완료!!!");
                }
                // 전송된 파일 업로드하고 새로운 파일 정보로 update
                String orgfilename=file1.getOriginalFilename();
                String savefilename=UUID.randomUUID()+"_" + orgfilename;
                File destFile=new File(filePath + File.separator +savefilename);
                file1.transferTo(destFile);
                long filesize=file1.getSize();
                FileinfoDto updateDto=FileinfoDto.builder()
                        .filenum(dto.getFilenum())
                        .title(dto.getTitle())
                        .writer(dto.getWriter())
                        .content(dto.getContent())
                        .orgfilename(orgfilename)
                        .savefilename(savefilename)
                        .filesize(filesize)
                        .build();
                service.update(updateDto);

            }else {// 수정할 파일이 전송안된 경우- 기존 파일 유지
                // 전송된 정보로 update 하지만 파일은 기존 정보를 유지
                FileinfoDto updateDto=FileinfoDto.builder()
                        .filenum(dto.getFilenum())
                        .title(dto.getTitle())
                        .writer(dto.getWriter())
                        .content(dto.getContent())
                        .orgfilename(fileinfo.getOrgfilename())
                        .savefilename(fileinfo.getSavefilename())
                        .filesize(fileinfo.getFilesize())
                        .build();
                service.update(updateDto);
            }
            model.addAttribute("result","success");
        }catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("result","fail");
        }
        return "result";
    }
}