package com.example.library.service.Impl;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;
    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(Book book) {
        if (repository.existsById(book.getId())){
            return false;
        }
        repository.save(book);
        return false;
    }

    @Override
    public boolean update(Book book) {
        if(repository.existsById(book.getId())){
            return true;
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }
}
