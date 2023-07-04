package com.example.bookapp.service.impl;

import com.example.bookapp.entity.Code;
import com.example.bookapp.repository.ICodeRepository;
import com.example.bookapp.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeServiceImpl implements ICodeService {
    @Autowired
    private ICodeRepository iCodeRepository;

    @Override
    public List<Code> findAllCodeByBookId(int id) {
        return iCodeRepository.findAllCodeByBookId(id);
    }

    @Override
    public void save(Code code) {
        iCodeRepository.save(code);
    }

    @Override
    public List<Code> findAllCode() {
        return iCodeRepository.findAll();
    }

    @Override
    public Code findById(int id) {
        return iCodeRepository.findById(id).orElse(null);
    }

    @Override
    public Code findByCode(int code) {
        return iCodeRepository.findByCode(code);
    }

    @Override
    public List<Code> findAllCodeByBookIdAndNotBorrowed(int id) {
        return iCodeRepository.findAllCodeByBookIdAndNotBorrowed(id);
    }
}
