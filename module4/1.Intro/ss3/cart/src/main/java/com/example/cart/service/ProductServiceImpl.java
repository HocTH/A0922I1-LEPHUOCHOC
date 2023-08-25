package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repo;
    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
           repo.save(product);
    }
}
