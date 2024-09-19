package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regdate;

    public MemberDto(Member mem) {
        this.id=mem.getId();
        this.pwd=mem.getPwd();
        this.email=mem.getEmail();
        this.age=mem.getAge();
        this.regdate=mem.getRegdate();
    }

    public Member toEntity() {
        //Member m=new Member(id, pwd, email, age, regdate);
        Member m=Member.builder()
                .id(this.id)
                .pwd(this.pwd)
                .email(this.email)
                .age(this.age)
                .regdate(this.regdate)
                .build();
        return m;
    }
}
















