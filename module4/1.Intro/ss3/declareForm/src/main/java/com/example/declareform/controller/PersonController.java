package com.example.declareform.controller;

import com.example.declareform.model.Person;
import com.example.declareform.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private HealthService healthService;
    @GetMapping("list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject(healthService.findAll());
        return modelAndView;
    }
    @GetMapping("form")
    public ModelAndView edit(@RequestParam int id){
           ModelAndView modelAndView = new ModelAndView("form");
           modelAndView.addObject("person",healthService.findById(id));
           return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("person",new Person());
        return modelAndView;
    }
    @PostMapping("save")
    public String save(@ModelAttribute("person") Person person){
        healthService.save(person);
        return "redirect:list";
    }
}
