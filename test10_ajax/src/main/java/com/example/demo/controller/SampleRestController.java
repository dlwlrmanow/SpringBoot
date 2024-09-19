package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MyUser;

@RestController
@RequestMapping("/user")
public class SampleRestController {
    //localhost:8080/user/info
    @GetMapping("/info")
    public ResponseEntity<MyUser> userinfo(){
        MyUser user=new MyUser("hello","1234","hello@");
        //ResponseEntity에 응답할 데이터와 응답코드(성공) 담기
        ResponseEntity<MyUser> responseEntity=new ResponseEntity<MyUser>(user,HttpStatus.OK);
        return responseEntity;
    }
    // url:'/user/info1/hello/1234'
    @GetMapping("/info1/{id}/{pwd}")
    public ResponseEntity<MyUser> userinfo1(@PathVariable("id") String id,@PathVariable("pwd") String pwd){
        MyUser user=null;
        if(id!=null && id.equals("hello") && pwd!=null && pwd.equals("1234")) {
            user=new MyUser("hello","1234","hello@");
        }else {
            user=new MyUser("none","none","none");
        }
        //ResponseEntity에 응답할 데이터와 응답코드(성공) 담기
        ResponseEntity<MyUser> responseEntity=new ResponseEntity<MyUser>(user,HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping(value="/list")
    public ResponseEntity<List<MyUser>> getList(){
        MyUser m1=new MyUser("hello1", "1234","hello1@");
        MyUser m2=new MyUser("hello2", "0000","hello2@");
        MyUser m3=new MyUser("hello3", "1111","hello3@");
        List<MyUser> list=new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        ResponseEntity<List<MyUser>> resp=new ResponseEntity<List<MyUser>>(list, HttpStatus.OK);
        return resp;
    }
}