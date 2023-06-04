package com.example.vegetable.service;

import java.util.List;

public interface ServiceSource<T> {
    boolean create(T t);
    boolean update(T t);
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
}
