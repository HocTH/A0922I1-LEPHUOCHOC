package com.example.bookapp.repository;

import com.example.bookapp.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICodeRepository extends JpaRepository<Code,Integer> {
    @Query(value = "select c from  Code c where c.book.bookId=:id")
    List<Code> findAllCodeByBookId(@RequestParam("id") int id);
    @Query(value = "select c from Code c where c.code=:code")
    Code findByCode(@RequestParam("code") int code);
    @Query(value = "select c from  Code c where c.book.bookId=:id and c.status='not borrowed' ")
    List<Code> findAllCodeByBookIdAndNotBorrowed(@RequestParam("id") int id);
}
