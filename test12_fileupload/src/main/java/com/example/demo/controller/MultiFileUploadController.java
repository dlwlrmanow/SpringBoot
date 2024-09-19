package com.example.demo.controller;

import com.example.demo.dto.FileinfoDto;
import com.example.demo.dto.MultiFileRequestDto;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class MultiFileUploadController {
    @Autowired
    private FileService service;

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/file/uploadFiles")
    private String uploadForm() {
        return "file/uploadFiles";
    }

    @PostMapping("/file/uploadFiles")
    private String upload(MultiFileRequestDto dto, Model model) throws IOException {
        // 다중 파일 업로드 코드 작성
        List<MultipartFile> filelist = dto.getFile1();

        filelist.forEach(f -> {
            try {
                String originalFilename = f.getOriginalFilename();
                String saveFileName = UUID.randomUUID() + "_" + originalFilename;
                f.transferTo(new File(filePath + File.separator + saveFileName));
                System.out.println(saveFileName + "파일 업로드 완료!");
                model.addAttribute("result", "success");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                model.addAttribute("result", "error");
            }
        });
        return "result";
    }
}
