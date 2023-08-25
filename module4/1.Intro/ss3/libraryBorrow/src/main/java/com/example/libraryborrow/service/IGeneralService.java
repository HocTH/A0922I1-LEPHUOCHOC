package com.example.libraryborrow.service;

import java.util.List;

public interface IGeneralService <E>{
    List<E> findAll();
    boolean save(E e);
    boolean update(E e);
    E findById(int id);
    boolean deleteById(int id);
}
