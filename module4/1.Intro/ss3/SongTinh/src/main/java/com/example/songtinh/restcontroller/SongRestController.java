package com.example.songtinh.restcontroller;

import com.example.songtinh.entity.Category;
import com.example.songtinh.entity.Song;
import com.example.songtinh.service.CategoryService;
import com.example.songtinh.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
@RequestMapping("/api/v1/song")
public class SongRestController {
    @Autowired
    SongService songService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/delete")
        public ResponseEntity<Song> delete(@RequestParam("id") int id){
        songService.deleteById(id);
//        return new ResponseEntity<>("ok",HttpStatus.OK);
        return new ResponseEntity<Song>(new Song(), HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Song>> getListProduct() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }
}
