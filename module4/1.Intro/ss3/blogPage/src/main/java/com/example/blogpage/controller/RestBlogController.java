package com.example.blogpage.controller;

import com.example.blogpage.entity.Blog;
import com.example.blogpage.entity.Category;
import com.example.blogpage.service.BlogService;
import com.example.blogpage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")\
@RequestMapping("/api/v1/blogs")
public class RestBlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListCategory(){
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Blog>> getListBlog(){
        return new ResponseEntity<>(blogService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findByBlogId(@PathVariable("id") int id){
        Blog blog= blogService.findById(id);
        if (blog!=null){
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> findByCategoryId(@PathVariable("id") int id){
        Category category= categoryService.findById(id);
        if (category!=null){
            return new ResponseEntity<>(category,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam("name") String name, Model model) {
        List<Blog> blogs = blogService.findBlogByName(name);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
