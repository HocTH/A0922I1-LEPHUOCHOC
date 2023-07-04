package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.BorrowBook;
import com.example.library.service.BookService;
import com.example.library.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowBookService borrowBookService;

    @GetMapping("/listbook")
    public String showListBook(Model model) {
        model.addAttribute("book", bookService.findAll());
        return "listBook";
    }
    @GetMapping("/listuser")
    public String showListUser(Model model){
        model.addAttribute("borrowBook", borrowBookService.findAll());
        return "listUser";
    }
    @GetMapping("/borrow")
    public String showBorrowForm(@RequestParam("id") int id, Model model) throws ParseException {
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setUserId((int) (10000 + Math.random()*9999));
        LocalDateTime today = LocalDateTime.now();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(today));
        borrowBook.setBorrowDate(date);
        model.addAttribute("books", bookService.findAll());
        borrowBook.setBook(bookService.findById(id));
        model.addAttribute("borrowBook", borrowBook);
        return "borrow";
    }
    @PostMapping("/borrow")
    public String doBorrow(@ModelAttribute("borrowBook") BorrowBook borrowBook){
        Book book = bookService.findById(borrowBook.getBook().getId());
        if (book.getQuantity() > 0){
            book.setQuantity(book.getQuantity() - 1);
        }
        borrowBook.setBook(book);
        borrowBookService.create(borrowBook);
        return "redirect:/library/listuser";
    }

}
