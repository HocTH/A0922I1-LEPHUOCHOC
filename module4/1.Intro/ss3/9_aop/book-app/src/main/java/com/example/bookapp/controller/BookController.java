package com.example.bookapp.controller;

import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.Code;
import com.example.bookapp.service.IBookService;
import com.example.bookapp.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private ICodeService iCodeService;
    @Autowired
    private IBookService iBookService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("books", iBookService.findAllBook());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        iBookService.save(book);
        return "redirect:/list";
    }

    @GetMapping("/borrow/{bookId}")
    public String showBorrow(@PathVariable("bookId") int bookId, Model model) {
        Book book=iBookService.findById(bookId);
        model.addAttribute("book", iBookService.findById(bookId));
        if (book.getQuantity()<=0){
            model.addAttribute("error","Tất cả sách đã được mượn");
            model.addAttribute("books", iBookService.findAllBook());
            return "/list";
        }
        model.addAttribute("codes", iCodeService.findAllCodeByBookIdAndNotBorrowed(bookId));
        return "/borrow";
    }

    @GetMapping("/return")
    public String showReturn() {
        return "/return";
    }

    @GetMapping("/doBorrow/{idCode}")
    public String doBorrow(@PathVariable("idCode") int id) {
        Code code = iCodeService.findById(id);
        Book book = iBookService.findById(code.getBook().getBookId());
        iBookService.borrow(book, code.getCode());
        return "redirect:/list";
    }

    @PostMapping("/doReturn")
    public String doReturn(@RequestParam("code") int code,Model model) {
        Code code1 = iCodeService.findByCode(code);
        if (code1==null){
            model.addAttribute("erorr","Không tìm thấy sách có mã vừa nhập");
            return "/return";
        }
        if (!code1.getStatus().equals("borrowed")){
            model.addAttribute("erorr","Sách này đã được mượn");
            return "/return";
        }
        Book book=iBookService.findById(code1.getBook().getBookId());
        iBookService.returnBook(book,code);
        return "redirect:/list";
    }


}
