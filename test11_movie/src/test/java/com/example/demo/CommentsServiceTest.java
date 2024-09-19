package com.example.demo;

import com.example.demo.dto.CommentsDto;
import com.example.demo.service.CommentsService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class CommentsServiceTest {
    @Autowired
    CommentsService service;

    @Test
    void save(){
        for(int i = 1; i <= 20; i++){
            service.save(new CommentsDto(0L, 1L, "wltn" + i, "good" + i));
        }
    }

    @Test
    void delete() {
        service.delete(1L);
    }
}
