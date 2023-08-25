package com.example.libraryborrow.controller;

import com.example.libraryborrow.entity.Card;
import com.example.libraryborrow.service.BookService;
import com.example.libraryborrow.service.CardService;
import com.example.libraryborrow.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CardService cardService;
    @GetMapping("/list")
    public String showListBook(Model model){
        model.addAttribute("books",bookService.findAll());
        return "/view/book/list";
    }
    @GetMapping("/borrowBook")
    String ShowDetail(@RequestParam("id") int id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "/view/book/detail";
    }
    @GetMapping("/doBorrowBook")
    public String showBorrowBook(@RequestParam("id")int id,Model model){
        Card card = new Card();
        card.setBook(bookService.findById(id));
        model.addAttribute("card",card);
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("book1",bookService.findById(id));
        return "/view/book/borrowBook";
    }
    @PostMapping("doBorrowBook")
    String doBorrowBook(@ModelAttribute("card") Card card){
        cardService.save(card);
        return "redirect:/book/list";
    }
}
