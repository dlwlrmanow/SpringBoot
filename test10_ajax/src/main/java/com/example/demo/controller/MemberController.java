package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    // 파라미터로 전송된 데이터를 db에 저장하고 결과를 json으로 응답하는 코드("success/fail") 완성해 보세요.
    @PostMapping("/member/join")
    public ResponseEntity<String> join(MemberDto dto) {
        String result = "success";
        try {
            memberService.join(dto);
        } catch (Exception e) {
            result = "fail";
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PutMapping("/member/update") // @PutMapping : update 하고자 할때
    //@RequestBody : 파라미터를 json타입으로 받을때
    public ResponseEntity<String> update(@RequestBody MemberDto dto) {
        String result = "success";
        try {
            memberService.update(dto);
        } catch (Exception e) {
            result = "fail";
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping("/member/list")
    public ResponseEntity<List<MemberDto>> list() {
        List<MemberDto> memberList = memberService.list();
        return new ResponseEntity<List<MemberDto>>(memberList, HttpStatus.OK);
    }

    @DeleteMapping("/member/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        String result = "success";
        try {
            memberService.delete(id);
        } catch (Exception e) {
            result = "fail";
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping("/member/select/{id}")
    public ResponseEntity<MemberDto> select(@PathVariable("id") String id) {
        MemberDto dto = memberService.select(id);
        return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
    }

    @GetMapping("/findid/{pwd}/{email}")
    public ResponseEntity<HashMap<String, Object>> findId(@PathVariable("pwd") String pwd, @PathVariable("email") String email) {
        System.out.println(pwd + ", " + email);
        HashMap<String, Object> map = new HashMap<>();

        MemberDto dto = memberService.findId(pwd, email);
        if(dto != null) {
            map.put("find", true);
            map.put("id", dto.getId());
        } else {
            map.put("find", false);
        }
        return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
    }
}