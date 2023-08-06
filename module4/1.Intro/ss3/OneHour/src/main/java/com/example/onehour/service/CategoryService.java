package com.example.onehour.service;

import com.example.onehour.entity.Category;
import com.example.onehour.entity.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface CategoryService {
    boolean update (Category category);
    boolean create(Category category);
    List<Category> findAll();
    Category findById(int id);
    boolean deleteById(int id);
}
