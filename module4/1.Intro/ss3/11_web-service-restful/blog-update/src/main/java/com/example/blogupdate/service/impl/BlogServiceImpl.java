package com.example.blogupdate.service.impl;


import com.example.blogupdate.entity.Blog;
import com.example.blogupdate.repository.IBlogRepository;
import com.example.blogupdate.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repository;
    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Blog> findAllWithSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchByName(String nameBlog, Pageable p) {
        return repository.searchByName("%"+nameBlog+"%",p);
    }
}
