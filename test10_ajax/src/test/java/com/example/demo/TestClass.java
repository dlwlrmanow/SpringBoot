package com.example.demo;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Transactional
@Commit
public class TestClass {
    @Autowired
    MemberRepository repository;

    @Test
    void test1() {
        MemberDto m = repository.findid("11", "aa@");
        System.out.println(m);

        Member m1 = repository.findByEmail("aa@");
        System.out.println(m1);
    }

    @Test
    void test2() {
        Member m = repository.findByEmail("aa@");
        System.out.println(m);

        Member m1 = repository.findByPwdAndEmail("11", "aa@");
        System.out.println(m1);
    }
}
