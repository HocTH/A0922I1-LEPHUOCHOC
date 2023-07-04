package com.example.addproducttocart.repository;

import com.example.addproducttocart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

}
