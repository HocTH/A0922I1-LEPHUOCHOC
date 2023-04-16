package com.example.baitapsanpham.service;

import com.example.baitapsanpham.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceI  implements  ProductService{
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"hoc",1000,"nguyen","my"));
        products.put(2,new Product(2,"hoc",1000,"nguyen","my"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
          products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
