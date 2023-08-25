package com.example.today21.service;

import com.example.today21.entity.Product;

import java.util.List;

public interface ProductService {
    void  create(Product product);
    void update(Product product);
    void deleteById(int id);
    List<Product> findAll();
    Product findById(int id);
}
