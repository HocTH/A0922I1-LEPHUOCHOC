package com.example.onehour.service;

import com.example.onehour.entity.Product;
import com.example.onehour.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository  repository;
    @Override
    public boolean update(Product product) {
        if (repository.existsById(product.getId())){
            repository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean create(Product product) {
        repository.save(product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findAllProductByName(String name) {
        return repository.findAllByNameContaining(name);
    }
}
