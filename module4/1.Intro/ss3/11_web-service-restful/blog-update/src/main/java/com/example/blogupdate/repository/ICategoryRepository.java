package com.example.blogupdate.repository;


import com.example.blogupdate.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category,Integer> {
}
