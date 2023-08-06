package com.example.songtinh.controller;

import com.example.songtinh.entity.Song;
import com.example.songtinh.entity.SongForm;
import com.example.songtinh.service.CategoryService;
import com.example.songtinh.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
@Autowired
    private CategoryService categoryService;
@Autowired
    private SongService songService;
@GetMapping("/list")
    public String showList(Model model, @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "2") int size,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "nameAuthor", defaultValue = "") String nameAuthor
                           ){
    Page<Song> songs;
    Pageable pageable = PageRequest.of(page,size);
    if (!name.isEmpty()){
        songs = songService.findAllByNameAndAuthor(pageable,name,nameAuthor) ;
    } else {
        songs= songService.findAll(pageable);
    }
    model.addAttribute("songs", songs);
    model.addAttribute("name", name);
    model.addAttribute("nameAuthor",nameAuthor);
    return "/view/song/list";
}
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("song", new SongForm());
        model.addAttribute("categories",categoryService.findAll());
        return "view/song/create";
    }
    @PostMapping("/create")
    public String doCreate(Model model, @ModelAttribute("song") SongForm songForm){
        MultipartFile multipartFile = songForm.getUrl();
        songForm.setCategory(categoryService.findById(songForm.getCategory().getCategoryId()));
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getUrl().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(),songForm.getAuthor(),songForm.getPrice(),songForm.getCategory(),fileName);
          songService.create(song);
        return "redirect:/song/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
    Song song = songService.findById(id);
    model.addAttribute("song", song);
    return "view/song/detail";
    }
    @GetMapping("update")
    public String showUpdate(Model model, @RequestParam("id") int id){
    Song song = songService.findById(id);
    SongForm songForm = new SongForm();
    BeanUtils.copyProperties(song,songForm);
    model.addAttribute("categories",categoryService.findAll());
    model.addAttribute("song", song);
    model.addAttribute("songForm", songForm);
    return "view/song/update";
    }
    @PostMapping("update")
    public String doUpdate(@ModelAttribute("songForm") SongForm songForm){
        Song song = songService.findById(songForm.getId());
        if (songForm.getUrl() != null){
            MultipartFile multipartFile = songForm.getUrl();
            String file = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(songForm.getUrl().getBytes(), new File(fileUpload + file));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            song = new Song(songForm.getId(), songForm.getName(),songForm.getAuthor(),songForm.getPrice(),songForm.getCategory(),file);
        }
        song.setCategory(categoryService.findById(song.getCategory().getCategoryId()));
      songService.update(song);
    return "redirect:/song/list";
    }
    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable("id") int id){
    songService.deleteById(id);
    return "redirect:/song/list";
    }
}
