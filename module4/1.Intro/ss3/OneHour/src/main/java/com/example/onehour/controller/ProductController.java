package com.example.onehour.controller;

import com.example.onehour.entity.Product;
import com.example.onehour.service.CategoryService;
import com.example.onehour.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("products", productService.findAll());
        return "view/product/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories",categoryService.findAll());
        return "view/product/create";
    }
     @PostMapping("/create")
    public String doCreate(Model model, @ModelAttribute("product") Product product){
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.create(product);
        return "redirect:/product/list";
     }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
        model.addAttribute("product", productService.findById(id));
        return "view/product/detail";
    }
    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam("id") int id){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories",categoryService.findAll());
        return "view/product/update";
    }
    @PostMapping("/update")
    public String doUpdate(Model model, @ModelAttribute("product") Product product){
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.update(product);
        return "redirect:/product/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id){
        productService.deleteById(id);
        return "redirect:/product/list";
    }
    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("name") String name){
        model.addAttribute("products", productService.findAllProductByName(name));
        model.addAttribute("name",name);
        return "view/product/list";
    }
}
