package com.example.blogupdate.controller;

import com.example.blogupdate.entity.Blog;
import com.example.blogupdate.entity.Category;
import com.example.blogupdate.service.IBlogService;
import com.example.blogupdate.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category>categories=iCategoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/listBlog")
    public ResponseEntity<List<Blog>> findAllBlog(){
        List<Blog>blogs=iBlogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findByBlogId(@PathVariable("id") int id){
        Blog blog= iBlogService.findById(id);
        if (blog==null){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> findByCategoryId(@PathVariable("id") int id){
        Category category= iCategoryService.findById(id);
        if (category==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
          return new ResponseEntity<>(HttpStatus.OK);
    }


}
