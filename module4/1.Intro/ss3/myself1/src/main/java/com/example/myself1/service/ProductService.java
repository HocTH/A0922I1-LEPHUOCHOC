package com.example.myself1.service;

import com.example.myself1.entity.Product;

import java.util.List;

public interface ProductService {
    boolean create(Product product);
    boolean update(Product product);
    Product findById(int id);
    List<Product> findAll();
    boolean deleteById( int id);
      List<Product> findProductByName(String name);
}
