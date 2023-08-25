package com.example.testpass.dataloader;

import com.example.testpass.entity.Category;
import com.example.testpass.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        String[] name = {"TV", "Telephone","Laptop"};
       if(categoryService.findAll().isEmpty()){
           for (int i = 0; i < name.length; i++) {
				Category category = new Category();
				category.setCategoryName(name[i]);
				categoryService.save(category);
			}
       }
    }
}
