package com.example.demo.mybatis;

import com.example.demo.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberMapper {
    int insert(Member member);
    Member select(String id);
    Member isMember(HashMap<String, String> map);
}
