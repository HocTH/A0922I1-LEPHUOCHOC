package com.example.library.service.Impl;

import com.example.library.entity.BorrowBook;
import com.example.library.repository.BookBorrowRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BorrowBookImpl implements BorrowBookService {
    @Autowired
    private BookBorrowRepository repository;
    @Override
    public List<BorrowBook> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(BorrowBook borrowBook) {
        if (repository.existsById(borrowBook.getUserId()) || ((borrowBook.getBook().getQuantity()) <= 0)){
            return false;
        }
        repository.save(borrowBook);
        return true;
    }

    @Override
    public boolean update(BorrowBook borrowBook) {
        if (repository.existsById(borrowBook.getUserId())){
            repository.save(borrowBook);
            return true;
        }
        return false;
    }

    @Override
    public BorrowBook findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }
}
