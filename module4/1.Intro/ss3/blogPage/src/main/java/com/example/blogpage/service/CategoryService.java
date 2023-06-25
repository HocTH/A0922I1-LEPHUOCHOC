package com.example.blogpage.service;

import com.example.blogpage.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean create(Category t);
    boolean update(Category t);
    Category findById(int id);
    List<Category> findAll();
    boolean deleteById(int id);
}
