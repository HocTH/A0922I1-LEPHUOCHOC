package com.example.library.repository;

import com.example.library.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowRepository extends JpaRepository<BorrowBook, Integer> {
}
