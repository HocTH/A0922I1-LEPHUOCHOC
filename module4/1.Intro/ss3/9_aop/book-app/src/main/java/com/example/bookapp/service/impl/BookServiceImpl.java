package com.example.bookapp.service.impl;

import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.Code;
import com.example.bookapp.repository.IBookRepository;
import com.example.bookapp.repository.ICodeRepository;
import com.example.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private ICodeRepository iCodeRepository;
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAllBook() {
        return iBookRepository.findAll();
    }

    @Override
    public boolean borrow(Book book, int usedCode) {
        if (book.getQuantity() == 0) {
            return false;
        }
        List<Code> codeList = iCodeRepository.findAllCodeByBookId(book.getBookId());
        for (Code c : codeList) {
            if (c.getCode().equals(usedCode)) {
                c.setStatus("borrowed");
                book.setQuantity(book.getQuantity() - 1);
                iCodeRepository.save(c);
                iBookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
        for (int i = 0; i < book.getQuantity(); i++) {
            int n = 10000 + new Random().nextInt(90000);
            Code code = new Code(n, "not borrowed",book);
            iCodeRepository.save(code);
        }
    }

    @Override
    public boolean returnBook(Book book, int usedCode) {

        List<Code> codeList = iCodeRepository.findAllCodeByBookId(book.getBookId());
        for (Code c : codeList) {
            if (c.getCode().equals(usedCode)){
                c.setStatus("not borrowed");
                book.setQuantity(book.getQuantity()+1);
                iCodeRepository.save(c);
                iBookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

}
