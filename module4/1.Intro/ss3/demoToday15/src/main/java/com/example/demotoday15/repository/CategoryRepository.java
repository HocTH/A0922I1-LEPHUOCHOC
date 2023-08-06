package com.example.demotoday15.repository;

import com.example.demotoday15.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
