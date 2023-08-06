package com.example.onehour.service;

import com.example.onehour.entity.Category;
import com.example.onehour.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository repository;

    @Override
    public boolean update(Category category) {
        if (repository.existsById(category.getCategoryId())){
            repository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean create(Category category) {
        repository.save(category);
        return true;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }
}
