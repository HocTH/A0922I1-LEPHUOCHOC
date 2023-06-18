package com.example.blogpage.repo;

import com.example.blogpage.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
