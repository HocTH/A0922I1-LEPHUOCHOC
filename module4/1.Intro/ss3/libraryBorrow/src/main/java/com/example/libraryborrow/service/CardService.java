package com.example.libraryborrow.service;

import com.example.libraryborrow.entity.Card;

import java.util.List;

public interface CardService extends IGeneralService<Card>{
    @Override
    List<Card> findAll();

    @Override
    boolean save(Card card);

    @Override
    boolean update(Card card);

    @Override
    Card findById(int id);

    @Override
    boolean deleteById(int id);
    boolean borrowBook(int bookId,int userId);
}
