package com.example.picturetnh.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentError {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
        model.addAttribute("error", e.getMessage());
        return "/view/comment/error";
    }
}
