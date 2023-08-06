package com.example.songtinh.service;

import com.example.songtinh.entity.Category;
import com.example.songtinh.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class CategoryServiceImpl implements CategoryService{
   @Autowired
   private CategoryRepository repo;
    @Override
    public boolean create(Category category) {
        repo.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (repo.existsById(category.getCategoryId())){
            repo.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) repo.findAll();
    }

    @Override
    public Category findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
