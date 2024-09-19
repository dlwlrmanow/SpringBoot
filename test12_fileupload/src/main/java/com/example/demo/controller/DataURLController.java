package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;

/*
 * Resource 인터페이스: Resource에 대한 접근을 추상화하기 위한 인터페이스
 * UrlResource : URL방식을 통해서 리소스의 위치를 알려주는 Resource객체
 */

@RestController
public class DataURLController {
    @Value("${file.path}")
    private String filePath;

    @ResponseBody
    @GetMapping("/images/{filename}") // src="/images/1.png" -> String filename에 들어간다
    public UrlResource showImage(@PathVariable("filename") String filename) throws MalformedURLException {
        return new UrlResource("file:" + filePath + File.separator + filename);
    }
}
