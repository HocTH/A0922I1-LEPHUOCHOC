package com.example.productmanager11.service;

import com.example.productmanager11.model.Product;

import java.util.List;

public interface productService {
     List<Product> findAll();
     void save(Product product);
     Product findById( int id);
     void update (int id, Product product);
     void remote (int id);

}
