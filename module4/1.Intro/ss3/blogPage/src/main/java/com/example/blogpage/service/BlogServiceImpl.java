package com.example.blogpage.service;

import com.example.blogpage.entity.Blog;
import com.example.blogpage.entity.Category;
import com.example.blogpage.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
       @Autowired
       private BlogRepository repository;
    @Override
    public boolean create(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        if(repository.existsById(blog.getId())){
            repository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {

        return (List<Blog>) repository.findAll();
    }
    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
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
    public List<Blog> findBlogByName(String name) {
        return repository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return repository.findAllByCategory(category);
    }

    @Override
    public List<Blog> sortByDate() {
        return repository.sortByDate();
    }
}
