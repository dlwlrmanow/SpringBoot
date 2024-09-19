package com.example.demo.service;

import com.example.demo.dto.Member;
import com.example.demo.mybatis.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {
    @Autowired private MemberMapper mapper;
    public int insert(Member member) {
        return mapper.insert(member);
    }
    public Member isMember(HashMap<String, String> map) {
        return mapper.isMember(map);
    }
    public Member select(String id) {
        return mapper.select(id);
    }
}
