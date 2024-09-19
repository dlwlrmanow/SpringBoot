package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ItemController {
    @GetMapping("/item/list1")
    public String itemList(Model model) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        model.addAttribute("list", list);
        return "item/list1";
    }

    @GetMapping("/item/list2")
    public String itemList2(Model model) {
        ArrayList<String> list = new ArrayList<>();
        list.add("사과");
        list.add("땅콩");
        list.add("수박");
        model.addAttribute("list", list);
        return "item/list2";
    }
}
