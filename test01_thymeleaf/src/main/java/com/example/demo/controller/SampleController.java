package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/test01")
    public String test01(Model model) {
        List<String> list1 = new ArrayList<>();
        list1.add("개나리");
        list1.add("진달래");
        list1.add("무궁화");
        model.addAttribute("list1", list1);

        List<User> list2 = new ArrayList<>();
        list2.add(new User("가", "1111"));
        list2.add(new User("나", "2222"));
        list2.add(new User("다", "3333"));
        list2.add(new User("라", "4444"));
        list2.add(new User("마", "5555"));
        model.addAttribute("list2", list2);

        Map<String, String> map = new HashMap<>();
        map.put("name", "김자바");
        map.put("email", "kim@");
        model.addAttribute("mem", map);

        Map<String, User> map02 = new HashMap<>();
        map02.put("user1", new User("a", "1111"));
        map02.put("user2", new User("b", "2222"));
        model.addAttribute("map02", map02);

        return "sample/test01";
    }

    @GetMapping("/test02Date")
    public String data(Model model) {
        model.addAttribute("date1", new Date());
        model.addAttribute("date2", LocalDateTime.now());
        return "sample/test02Date";
    }
    @GetMapping("/link1")
    public String link1(@RequestParam("id") String id, @RequestParam("pwd") String pwd){
        System.out.println("id:" + id);
        System.out.println("pwd:" + pwd);
        return "sample/result";
    }
    // href="/sample/link2/aaa/1234"
    @GetMapping("/link2/{id}/{pwd}") // {} 안으로 해당 값 들어옴
    public String link2(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
        System.out.println("id: " + id + ", pwd: " + pwd);
        return "sample/result";
    }
    @GetMapping("/link3/{id}/{pwd}") // {} 안으로 해당 값 들어옴
    public String link3(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
        System.out.println("id: " + id + ", pwd: " + pwd);
        return "sample/result";
    }

    @GetMapping("/form") // return값이 없으면 자동으로 찾아서 맵핑주소와 똑같은 곳으로 보내준다.
    public void form(Model model) {
        Member m = new Member("test", "1234","test@test.com", false);
        model.addAttribute("mem", m);
    }
    @GetMapping("/formOk")
    public void formOk(@ModelAttribute Member m) { // @ModelAttribute model 객체에 담아줌
        System.out.println("formOk -> + " + m);
    }

}
