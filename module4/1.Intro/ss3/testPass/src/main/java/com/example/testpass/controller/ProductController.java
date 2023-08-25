package com.example.testpass.controller;

import com.example.testpass.entity.Category;
import com.example.testpass.entity.Product;
import com.example.testpass.exception.AdminException;
import com.example.testpass.service.CategoryService;
import com.example.testpass.service.ProductService;
import com.example.testpass.validate.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductValidation validation;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "4") int size,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "price", defaultValue = "0") int price,
                           @RequestParam(value = "categoryID", defaultValue = "1") int categoryID
    ) {
        Page<Product> products;
        Pageable pageable = PageRequest.of(page, size);
        products = productService.findAll(pageable);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("categories",categories);
        return "view/product/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model, RedirectAttributes redirectAttributes) {
        List<Category> categories = categoryService.findAll();
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "view/product/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult, Model model
            , RedirectAttributes redirectAttributes) {
        validation.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "view/product/create";
        }
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.save(product);
        redirectAttributes.addFlashAttribute("messenger", "Successful created.");
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String showSearch(Model model,
                             @RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "price", defaultValue = "0") int price,
                             @RequestParam(value = "categoryID", defaultValue = "1") int categoryID
    ) {
        List<Product> products;
        products = productService.findByNameAndPrice(name, price,categoryID);
        List<Category> categories = categoryService.findAll();
        System.out.println(categoryID);
        model.addAttribute("products", products);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("categories",categories);
        return "view/product/listSearch";
    }
}
