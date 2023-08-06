package com.example.test.repository;

import com.example.test.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Pattern;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByNameContaining(String name);
    @Query(value = "select  Product p from Product where p.category_id = :categoryId")
    List<Product> findAllByCategoryId(@PathVariable("categoryId") int categoryId);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAll( Pageable pageable);
}
