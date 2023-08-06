package com.example.test.service;

import com.example.test.entity.Product;
import com.example.test.repository.ProductRepository;
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
    private ProductRepository repository;
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
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> findProductByName(String name) {
        return (List<Product>) repository.findAllByNameContaining(name);
    }

    @Override
    public Page<Product> findAllPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Product> findProductByNamePaging(String name, Pageable pageable) {
        return repository.findAllByNameContaining(name,pageable);
    }

//    @Override
//    public Page<Product> findProductByPricePaging(int price, Pageable pageable) {
//        return repository.findAllByPriceContaining(price,pageable);
//    }

}
