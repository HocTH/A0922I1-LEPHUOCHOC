package com.example.libraryborrow.service;

import com.example.libraryborrow.entity.Book;
import com.example.libraryborrow.entity.Card;
import com.example.libraryborrow.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository repo;
    @Autowired
    BookService bookService;
    @Autowired
    StudentService studentService;
    @Override
    public List<Card> findAll() {
        return (List<Card>) repo.findAll();
    }

    @Override
    public boolean save(Card card) {
        card.setStudent(studentService.findById(card.getStudent().getIdStudent()));
        Book book = bookService.findById(card.getBook().getIdBook());
        book.setQuantity(book.getQuantity()-1);
        bookService.update(book);
        card.setBorrowedDay();
        repo.save(card);
        return true;
    }

    @Override
    public boolean update(Card card) {
        if (repo.existsById(card.getId())){
            repo.save(card);
            return true;
        }
        return false;
    }

    @Override
    public Card findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean borrowBook(int bookId,int userId) {
        Card card=new Card(bookService.findById(bookId),studentService.findById(userId));
        bookService.findById(bookId).setQuantity(bookService.findById(bookId).getQuantity()-1);
        this.save(card);
        return true;
    }
}
