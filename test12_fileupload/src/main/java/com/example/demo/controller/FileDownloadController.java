package com.example.demo.controller;

import com.example.demo.dto.FileinfoDto;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriUtils;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@Controller
public class FileDownloadController {
    @Autowired private FileService service;

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/file/download")
    public ResponseEntity<Resource> download(int filenum) throws MalformedURLException {
        FileinfoDto dto = service.select(filenum);
        String saveFileName = dto.getSavefilename();
        String orgFileName = dto.getOrgfilename();
        // 파일명이 한글인 경우 깨지지 않도록 인코딩
        String fileName = UriUtils.encode(orgFileName, StandardCharsets.UTF_8);
        UrlResource resource = new UrlResource("file: " + filePath + saveFileName); //예외처리
        String contentDisposition = "attachment; filename=\"" + fileName + "\"";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }
}
