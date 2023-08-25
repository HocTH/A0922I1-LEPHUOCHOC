package com.example.testpass.service;

import com.example.testpass.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends GeneralIService<Product>{
List<Product> findByNameAndPrice(String name, int price,int categoryId);
}
