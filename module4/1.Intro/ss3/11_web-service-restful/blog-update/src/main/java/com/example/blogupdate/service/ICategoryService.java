package com.example.blogupdate.service;

import com.example.blogupdate.entity.Category;

import java.util.List;

public interface ICategoryService {
    void createCategory(Category category);
    List<Category> findAll();
    void create(Category category);
    void deleteById(int id);
    void update(Category category);
    Category findById(int id);
}
