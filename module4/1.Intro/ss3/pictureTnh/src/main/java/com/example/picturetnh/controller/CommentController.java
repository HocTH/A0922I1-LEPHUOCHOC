package com.example.picturetnh.controller;

import com.example.picturetnh.entity.Comment;
import com.example.picturetnh.service.CommentService;
import com.example.picturetnh.validate.CommentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private  CommentValidate commentValidate;
//    @GetMapping("/list")
//    public String showList(Model model){
//        model.addAttribute("comment", new Comment());
//        model.addAttribute("comments",commentService.findAll());
//        return "view/comment/list";
//    }
    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("comment") Comment comment, BindingResult bindingResult,
                           Model model, @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "2") int size
                           ) throws Exception {
        if (bindingResult.hasErrors()){
            Page<Comment> comments;
            Pageable pageable = PageRequest.of(page,size);
            comments=commentService.findAllPaging(pageable);
            model.addAttribute("comments",comments);
            return "view/comment/list";
        }
        String[] list = {"dm", "fuck","none"};
        for (String banWord:list) {
            if (comment.getFeedBack().contains(banWord)){
                throw new Exception();
            }
        }
        comment.setDate();
        commentService.save(comment);
        return "redirect:/comment/list";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id){
        Comment comment = commentService.findById(id);
        commentService.update(comment);
        return "redirect:/comment/list";
    }
    @GetMapping("/list")
    public String showList(Model model, @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "2") int size ){
        Page<Comment> comments;
        Pageable pageable = PageRequest.of(page,size);
        comments=commentService.findAllPaging(pageable);
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments",comments);
        return "view/comment/list";
    }
}
