package com.example.libraryborrow.service;

import com.example.libraryborrow.entity.Book;

import java.util.List;

public interface BookService extends IGeneralService<Book>{
    @Override
    List<Book> findAll();

    @Override
    Book findById(int id);

    @Override
    boolean save(Book book);

    @Override
    boolean update(Book book);

    @Override
    boolean deleteById(int id);
}
