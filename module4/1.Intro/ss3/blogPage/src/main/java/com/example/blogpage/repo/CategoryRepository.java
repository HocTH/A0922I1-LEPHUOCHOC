package com.example.blogpage.repo;

import com.example.blogpage.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {

}
