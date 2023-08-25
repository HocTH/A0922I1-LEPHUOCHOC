package com.example.testpass.repository;
import com.example.testpass.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
  @Query(value = "select p from  Product p where p.name like :name and p.price >= :price and p.category.categoryId = :categoryId")
   List<Product> findByNameAndPrice( @Param("name") String name, @Param("price") int price,@Param("categoryId") int categoryId);
//    @Query(value = "select p from  Product p where p.name like : name and p.price >= :price")
//    List<Product> findByNameAndPrice( @Param("name") String name, @Param("price") int price);
}
