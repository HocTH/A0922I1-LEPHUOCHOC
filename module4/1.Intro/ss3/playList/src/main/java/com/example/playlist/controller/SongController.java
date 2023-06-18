package com.example.playlist.controller;

import com.example.playlist.entity.Song;
import com.example.playlist.service.SongService;
import com.example.playlist.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("songs",songService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("song", new Song());
    return "create";
    }
    @PostMapping("create")
    public String doCreate(@ModelAttribute("song") Song song){
        songService.create(song);
        return "redirect:/song/list";
    }
    @GetMapping("detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Song song   = songService.findById(id);
        model.addAttribute("song", song);
        return "detail";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("song") Song song) {
        songService.update(song);
        return "redirect:/song/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        songService.delete(id);
        return "redirect:/song/list";
    }
}
