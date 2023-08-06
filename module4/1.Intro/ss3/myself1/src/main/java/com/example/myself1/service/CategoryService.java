package com.example.myself1.service;

import com.example.myself1.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean create(Category category);
    boolean update(Category category);
    Category findById(int id);
    List<Category> findAll();
    boolean deleteById( int id);
}
