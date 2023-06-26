package com.example.demo.controller;

import com.example.demo.entity.Song;
import com.example.demo.service.SongService;
import com.example.demo.validate.SongValidate;
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
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping("/list")
    public ModelAndView showList(){
        List<Song> songs =songService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("songs",songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute(new Song());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "create";
        }
        songService.create(song);
        model.addAttribute("messenger","Successfully");
        return "redirect:list";
    }
}
