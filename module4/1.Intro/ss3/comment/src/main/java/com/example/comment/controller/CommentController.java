package com.example.comment.controller;

import com.example.comment.entity.Comment;
import com.example.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String doCreate(@ModelAttribute("comment") Comment comment){
        commentRepository.create(comment);
        return "redirect:/comment";
}
}
