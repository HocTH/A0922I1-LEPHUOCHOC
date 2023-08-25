package com.example.today21.service;

import com.example.today21.entity.Category;
import com.example.today21.repository.CategoryRepository;
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
    public void create(Category category) {
        repo.save(category);
    }

    @Override
    public void update(Category category) {
        if (repo.existsById(category.getCategoryId())){
            repo.save(category);
        }
    }

    @Override
    public void deleteById(int id) {
        if (repo.existsById(id)){
           repo.deleteById(id);
        }
    }

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
