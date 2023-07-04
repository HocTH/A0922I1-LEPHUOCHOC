package com.example.library.service;

import com.example.library.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    boolean create(Book book);
    boolean update(Book book);
    Book findById(int id);
    boolean deleteById(int id);
}
