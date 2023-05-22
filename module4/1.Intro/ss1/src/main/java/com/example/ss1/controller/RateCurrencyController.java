package com.example.ss1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class RateCurrencyController {
    @GetMapping("loginCurrency")
    public String login(){
        return "changeRate";
    }
    @GetMapping("changeCurrency")
    public String search(@RequestParam String inputRate, @RequestParam String inputQuantity, Model model){
        Integer inputRateReve = Integer.valueOf(inputRate);
        Integer inputQuantityReve = Integer.valueOf(inputQuantity);
        Integer result = inputRateReve * inputQuantityReve;
        model.addAttribute("result",result+" VND");
        model.addAttribute("inputRate",inputRate);
        model.addAttribute("inputQuantity",inputQuantity);
        return "changeRate";
    }

}
