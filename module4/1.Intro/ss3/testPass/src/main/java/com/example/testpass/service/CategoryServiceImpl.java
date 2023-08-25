package com.example.testpass.service;

import com.example.testpass.entity.Category;
import com.example.testpass.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository repo;
    @Override
    public boolean update(Category category) {
        if (repo.existsById(category.getCategoryId())){
            repo.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean save(Category category) {
        repo.save(category);
        return true;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) repo.findAll();
    }

    @Override
    public Category findById(int id) {
        return repo.findById(id).orElse(null);
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
    public Page<Category> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
