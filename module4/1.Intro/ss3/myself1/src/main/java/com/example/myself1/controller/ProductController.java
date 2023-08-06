package com.example.myself1.controller;

import com.example.myself1.entity.Product;
import com.example.myself1.service.CategoryService;
import com.example.myself1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("products",productService.findAll());
        return "view/product/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name,Model model){
        List<Product> productList = productService.findProductByName(name);
        model.addAttribute("products", productList);
        model.addAttribute("name",name);
        return "view/product/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "view/product/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product ){
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
         productService.create(product);
         return "redirect:/product/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
        model.addAttribute("product",productService.findById(id));
        return "view/product/detail";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id,Model model){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "view/product/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product){
        product.setCategory(categoryService.findById(product.getId()));
        productService.update(product);
        return "redirect:/product/list";
    }
}
