package com.example.libraryborrow.service;

import com.example.libraryborrow.entity.Student;

import java.util.List;

public interface StudentService extends IGeneralService<Student>{
    @Override
    List<Student> findAll();

    @Override
    boolean save(Student student);

    @Override
    boolean update(Student student);

    @Override
    Student findById(int id);

    @Override
    boolean deleteById(int id);
}
