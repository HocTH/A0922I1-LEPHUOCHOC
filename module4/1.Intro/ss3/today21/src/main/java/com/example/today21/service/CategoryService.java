package com.example.today21.service;

import com.example.today21.entity.Category;

import java.util.List;

public interface CategoryService {
    void  create(Category category);
    void update(Category category);
    void deleteById(int id);
    List<Category> findAll();
    Category findById(int id);
}
