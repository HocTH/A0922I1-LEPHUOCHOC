package com.example.testpass.service;

import com.example.testpass.entity.Product;
import com.example.testpass.exception.AdminException;
import com.example.testpass.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repo;
    @Override
    public boolean update(Product product) {
        if (repo.existsById(product.getId())){
            repo.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean save(Product product)  {
        repo.save(product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repo.findAll();
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Product> findByNameAndPrice(String name, int price,int categoryId) {
        return repo.findByNameAndPrice(name,price,categoryId);
    }
}
