package com.example.libraryborrow.repository;

import com.example.libraryborrow.entity.Book;
import com.example.libraryborrow.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends PagingAndSortingRepository<Card, Integer> {
}
