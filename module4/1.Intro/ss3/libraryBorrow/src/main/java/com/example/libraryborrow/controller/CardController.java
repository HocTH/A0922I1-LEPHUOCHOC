package com.example.libraryborrow.controller;

import com.example.libraryborrow.entity.Book;
import com.example.libraryborrow.service.BookService;
import com.example.libraryborrow.service.CardService;
import com.example.libraryborrow.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CardService cardService;
    @GetMapping("/list")
    public String showListCard(Model model){
        model.addAttribute("cards",cardService.findAll());
        return "/view/card/list";
    }
    @GetMapping("/detail")
    String ShowDetail(@RequestParam("id") int id, Model model){
        model.addAttribute("card",cardService.findById(id));
        return "/view/card/detail";
    }
    @GetMapping("doPayBook")
    String doPayBook(@RequestParam("id") int id, Model model){
        Book book = bookService.findById(cardService.findById(id).getBook().getIdBook());
        book.setQuantity(book.getQuantity()+1);
        bookService.update(book);
        cardService.deleteById(id);
        return "redirect:/card/list";
    }
}
