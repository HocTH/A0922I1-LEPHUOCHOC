package com.example.blogupdate.service;

import com.example.blogupdate.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void create(Blog blog);
    void deleteById(int id);
    void update(Blog blog);
    Blog findById(int id);
    Page<Blog> findAllWithPaging(Pageable pageable);
     Slice<Blog> findAllWithSlice(Pageable pageable);
    Page<Blog> searchByName(String nameBlog,Pageable p);


}
