package com.example.onehour.service;

import com.example.onehour.entity.Product;

import java.util.List;

public interface ProductService {
    boolean update (Product product);
    boolean create(Product product);
    List<Product> findAll();
    Product findById(int id);
    boolean deleteById(int id);
    List<Product> findAllProductByName(String name);
}
