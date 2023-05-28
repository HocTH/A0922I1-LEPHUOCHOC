package com.example.demo1.controller;

import com.example.demo1.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @GetMapping("home")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("person", new Person());
        return modelAndView;
    }
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject(person);
        return modelAndView;
    }
}
