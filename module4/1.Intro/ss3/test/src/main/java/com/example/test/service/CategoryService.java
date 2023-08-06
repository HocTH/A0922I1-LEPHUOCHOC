package com.example.test.service;

import com.example.test.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean update(Category category);
    boolean create(Category category);
    boolean deleteById(int id);
    Category findById(int id);
    List<Category> findAll();
}
