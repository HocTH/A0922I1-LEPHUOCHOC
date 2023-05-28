package com.example.mailbox.controller;

import com.example.mailbox.model.Mail;
import com.example.mailbox.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @Autowired
    MailService mailService;
    @GetMapping("home")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("mails",mailService.findAll());
        return modelAndView;
    }
    @GetMapping("update")
    public ModelAndView showForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("mail",mailService.findById(id));
        modelAndView.addObject("languages", mailService.takeLanguages());
        modelAndView.addObject("sizes", mailService.takeSizes());
        return modelAndView;
    }
    @PostMapping("save")
    public String save(@ModelAttribute("mail") Mail mail){
        mailService.save(mail);
        return "redirect:home";
    }

}
