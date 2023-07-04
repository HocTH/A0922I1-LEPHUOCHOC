package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.BorrowBook;

import java.util.List;

public interface BorrowBookService {
    List<BorrowBook> findAll();
    boolean create(BorrowBook borrowBook);
    boolean update(BorrowBook borrowBook);
    BorrowBook findById(int id);
    boolean deleteById(int id);
}
