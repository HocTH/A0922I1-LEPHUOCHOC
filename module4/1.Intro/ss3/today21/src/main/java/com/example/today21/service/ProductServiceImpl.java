package com.example.today21.service;

import com.example.today21.entity.Product;
import com.example.today21.repository.ProductRepository;
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
    public void create(Product product) {
        repo.save(product);
    }

    @Override
    public void update(Product product) {
        if(repo.existsById(product.getId())){
            repo.save(product);
        }

    }

    @Override
    public void deleteById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
