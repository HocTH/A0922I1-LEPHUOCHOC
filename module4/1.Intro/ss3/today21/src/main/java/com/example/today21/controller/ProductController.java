package com.example.today21.controller;

import com.example.today21.entity.Product;
import com.example.today21.service.CategoryService;
import com.example.today21.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public String showList(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "view/product/list";
    }
}
