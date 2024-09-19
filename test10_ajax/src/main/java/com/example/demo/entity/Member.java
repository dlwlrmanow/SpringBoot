package com.example.demo.entity;



import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {
    @Id
    private String id;
    @Column(length = 10)
    private String pwd;
    private String email;
    private int age;
    @CreationTimestamp
    private Date regdate;
}