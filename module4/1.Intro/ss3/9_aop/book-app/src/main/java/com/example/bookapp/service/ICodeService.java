package com.example.bookapp.service;

import com.example.bookapp.entity.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAllCodeByBookId(int id);
    void save(Code code);
    List<Code> findAllCode();
    Code findById(int id);
    Code findByCode(int code);
    List<Code> findAllCodeByBookIdAndNotBorrowed(int id);

}
