package com.example.bookapp.service;

import com.example.bookapp.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();
    boolean borrow(Book book,int usedCode);
    void save(Book book);
    boolean returnBook(Book book,int usedCode);
    Book findById(int id);


}
