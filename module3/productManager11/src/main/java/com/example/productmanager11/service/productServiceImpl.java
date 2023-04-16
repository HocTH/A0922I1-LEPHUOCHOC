package com.example.productmanager11.service;

import com.example.productmanager11.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class productServiceImpl implements productService{
    private static Map<Integer,Product> products;
    static {
        products.put(1,new Product(1,"TV",10000,"Television","Honda"));
        products.put(2,new Product(2,"Car",40000,"Car","Yamaha"));
        products.put(3,new Product(3,"Lap",60000,"Laptop","Honda"));
        products.put(4,new Product(4,"Desktop",60000,"Desktop","Hpp"));
        products.put(5,new Product(5,"Phone",40000,"Phone","Samsung"));
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
    public void remote(int id) {
   products.remove(id);
    }
}
