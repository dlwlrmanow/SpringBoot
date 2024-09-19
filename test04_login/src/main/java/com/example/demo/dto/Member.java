package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regdate;
}
