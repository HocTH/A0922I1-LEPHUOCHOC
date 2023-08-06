package com.example.demotoday15.service;

import com.example.demotoday15.entity.Category;
import com.example.demotoday15.entity.Product;

import java.util.List;

public interface CategoryService {
    boolean update(Category category);
    boolean create(Category category);
    boolean deleteById(int id);
    Category findById(int id);
    List<Category> findAll();
}
