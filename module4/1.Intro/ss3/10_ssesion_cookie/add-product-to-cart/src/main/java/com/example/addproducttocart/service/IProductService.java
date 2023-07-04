package com.example.addproducttocart.service;

import com.example.addproducttocart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
