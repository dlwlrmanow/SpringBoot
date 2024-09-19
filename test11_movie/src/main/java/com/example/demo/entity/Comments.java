package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = {"movie"}) // 얘는 다른 테이블이니까 제외
@Builder
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mnum")
    private Movie movie;
    private String id;
    private String comments;
}