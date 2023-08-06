package com.example.songtinh.service;

import com.example.songtinh.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean create(Category category);
    boolean update(Category category);
    boolean deleteById(int id);
    List<Category> findAll();
    Category findById( int id);

}
