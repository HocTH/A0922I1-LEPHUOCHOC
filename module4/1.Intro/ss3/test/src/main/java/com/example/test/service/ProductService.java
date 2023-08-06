package com.example.test.service;

import com.example.test.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    boolean update(Product product);
    boolean create(Product product);
    boolean deleteById(int id);
    Product findById(int id);
    List<Product> findAll();
    List<Product> findProductByName(String name);
    Page<Product> findAllPaging(Pageable pageable);
    Page<Product> findProductByNamePaging(String name, Pageable pageable);
//    Page<Product> findProductByPricePaging(int price, Pageable pageable);
}
