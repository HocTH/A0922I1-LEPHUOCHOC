package com.example.ss1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Translation {
    @GetMapping("loginTranslate")
    public String login(){
        return "dictionary";
    }
    @GetMapping("translate")
    public String translate(@RequestParam String inputWord, Model model){
        Map<String,String > vocab =new HashMap<>();
        vocab.put("hello", "Xin chào");
        vocab.put("how", "Thế nào");
        vocab.put("book", "Quyển vở");
        vocab.put("computer", "Máy tính");
        String search = vocab.get(inputWord);
        if(search == null){
            search = "Not found";
        }
        model.addAttribute("result",search);
        model.addAttribute("inputWord",inputWord);
        return "dictionary";
    }
}
