package com.example.demo_2805.controller;

import com.example.demo_2805.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("gendersArray", new String[]{"Male","Female"});
        modelAndView.addObject("hobbiesArray", new String[]{"Shopping","Traveling"});
        modelAndView.addObject("typesArray", new String[]{"Internal","External"});
        modelAndView.addObject("countriesArray", new String[]{"Hue","Dang"});
        return modelAndView;
    }
    @PostMapping("create-user")
    public ModelAndView createUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
