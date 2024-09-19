package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class UserServiceTest {
    @Autowired private UserService service;

    @Test
    void save() {
        service.save(new User(0L, "user01", "0000", "MEMBER"));
    }

    @Test
    void isMember() {
        boolean result = service.isMember("user01", "0000");
        System.out.println("result: " + result);
    }
}
