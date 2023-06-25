package com.example.blogpage.service;

import com.example.blogpage.entity.Blog;
import com.example.blogpage.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;


public interface BlogService {
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    boolean delete(int id);
    Page<Blog> findAllWithPaging(Pageable pageable);
    public Slice<Blog> findAllWithSlice(Pageable pageable);
    List<Blog> findBlogByName(String name);
    Iterable<Blog> findAllByCategory(Category category);
}
