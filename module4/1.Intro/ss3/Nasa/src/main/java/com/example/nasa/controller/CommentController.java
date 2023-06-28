package com.example.nasa.controller;

import com.example.nasa.entity.Comment;
import com.example.nasa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentRepository;
    @RequestMapping("/comment")
    public String showList(Model model){
        model.addAttribute("comment",new Comment());
        model.addAttribute("comments",commentRepository.findAll());
        return "show";
    }
@PostMapping("/create")
    public String doCreate(@ModelAttribute("comment") Comment comment, @RequestParam("id") int id) throws Exception{
         String[] list = {"dm", "fuck","hate"};
         String[] authorError ={"messi","ronaldo"};

    for (String c:list) {
        if(comment.getFeedBack().contains(c)){
            throw new Exception();
        }
    }
    for (String a: authorError) {
        if (comment.getAuthor().contains(a)){
            throw new Exception();
        }
    }
        commentRepository.create(comment);
        return "redirect:/comment";
}
@GetMapping("/update/{id}")
public String doUpdate( @PathVariable("id")  int id){
        Comment comment = commentRepository.findById(id);
    commentRepository.update(comment);
    return "redirect:/comment";
}}
