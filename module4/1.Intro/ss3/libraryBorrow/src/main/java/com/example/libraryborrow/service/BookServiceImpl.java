package com.example.libraryborrow.service;

import com.example.libraryborrow.entity.Book;
import com.example.libraryborrow.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository repo;
    @Override
    public List<Book> findAll() {
        return (List<Book>) repo.findAll();
    }

    @Override
    public Book findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean save(Book book) {
        repo.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        if (repo.existsById(book.getIdBook())){
           repo.findById(book.getIdBook());
           return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
