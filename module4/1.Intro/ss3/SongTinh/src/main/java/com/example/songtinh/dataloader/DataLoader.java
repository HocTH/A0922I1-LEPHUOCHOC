package com.example.songtinh.dataloader;

import com.example.songtinh.entity.Category;
import com.example.songtinh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        String[] name = {"tinh", "hoc","nghia"};
       if(categoryService.findAll().isEmpty()){
           for (int i = 0; i < name.length; i++) {
				Category category = new Category();
				category.setCategoryName(name[i]);
				categoryService.create(category);
			}
       }
    }
}
