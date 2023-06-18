package com.example.blogpage.service;

import com.example.blogpage.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BlogService {
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    boolean delete(int id);
    Page<Blog> findAllWithPaging(Pageable pageable);
}
