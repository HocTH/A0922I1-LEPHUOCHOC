package com.example.onehour.repository;

import com.example.onehour.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer > {
    List<Product> findAllByNameContaining(String name);
}
