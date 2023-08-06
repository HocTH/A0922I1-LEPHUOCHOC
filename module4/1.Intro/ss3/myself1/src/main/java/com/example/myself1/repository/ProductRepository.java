package com.example.myself1.repository;

import com.example.myself1.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByNameContaining(String name);
}
