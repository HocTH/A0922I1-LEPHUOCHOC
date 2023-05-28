package com.example.mail_box.controller;

import com.example.mail_box.model.Mail;
import com.example.mail_box.repository.IMail;
import com.example.mail_box.repository.MailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {
@Autowired
    private MailRepo mailRepo;
@GetMapping("list")
    public ModelAndView showList(){
    ModelAndView modelAndView =  new ModelAndView("list","mails",mailRepo.findAll());
    return modelAndView;
}
    @GetMapping("/update")
    public String showEdit(@RequestParam int id, Model model){
        model.addAttribute("mail",mailRepo.findById(id));
        model.addAttribute("languagesList",mailRepo.findLanguage());
        model.addAttribute("pageSize",mailRepo.findSize());
        return "edit";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes){
        mailRepo.save(mail);
        redirectAttributes.addFlashAttribute("mess","thành công");
        return "redirect:/list";
    }
}
