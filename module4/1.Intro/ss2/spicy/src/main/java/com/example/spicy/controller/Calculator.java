package com.example.spicy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {
    @GetMapping("loginCalculator")
    public String loadIndex() {
        return "calculator";
    }
    @GetMapping(path = "calculate")
    public ModelAndView calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("action") String action

            ) {
        double result = 0;
        switch (action){
            case "cong":
                result = num1+num2 ;
                break;
            case "tru":
                result = num1-num2;
                break;
            case "nhan":
                result = num1*num2;
                break;
            case "chia":
                result = num1/num2;
                break;
        }
        ModelAndView modelAndView =  new ModelAndView("calculator");
        modelAndView.addObject("result",result);
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("num2",num2);
        return modelAndView;
    }
}
