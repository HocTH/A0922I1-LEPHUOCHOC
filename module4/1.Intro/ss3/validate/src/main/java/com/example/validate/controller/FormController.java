package com.example.validate.controller;

import com.example.validate.Validate.FormValidate;
import com.example.validate.model.Form;
import com.example.validate.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FormController {
    @Autowired
    private FormService formService;
    @Autowired
    private FormValidate formValidate;;
    @GetMapping("/list")
    public ModelAndView showList(){
        List<Form> forms =formService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("forms",forms);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute(new Form());
    return "create";
    }
    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute ("form") Form form, BindingResult bindingResult,Model model){
        formValidate.validate(form,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        formService.create(form);
        model.addAttribute("messenger","Successfully");
        return "redirect:list";
    }
}
