package com.example.myself1.service;

import com.example.myself1.entity.Category;
import com.example.myself1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService{
          @Autowired
          private CategoryRepository repository;
    @Override
    public boolean create(Category category) {
        repository.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        if (repository.existsById(category.getCategoryId())){
            repository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }
}
