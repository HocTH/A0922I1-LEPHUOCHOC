package com.example.demotoday15.controller;

import com.example.demotoday15.entity.Category;
import com.example.demotoday15.entity.Product;
import com.example.demotoday15.service.CategoryService;
import com.example.demotoday15.service.ProductService;
import com.example.demotoday15.validate.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductValidate validate;
    @GetMapping("/list")
    public String showList(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
          return "view/product/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        return "view/product/create";
    }
    @PostMapping("/create")
    public String doCreate(@Validated  @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
        validate.validate(product,bindingResult);
        if (bindingResult.hasErrors()){
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "view/product/create";
        }
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.create(product);
        return "redirect:/product/list";
    }
    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam("id") int id){
          model.addAttribute("product",productService.findById(id));
          model.addAttribute("categories", categoryService.findAll());
    return "view/product/update";
    }
    @PostMapping("/update")
    public String doUpdate(Model model, @ModelAttribute("product") Product product){
        product.setCategory(categoryService.findById(product.getCategory().getCategoryId()));
        productService.update(product);
        return "redirect:/product/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model,@PathVariable("id") int id ){
        model.addAttribute("product", productService.findById(id));
        return "view/product/detail";
    }

    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable("id") int id){
        productService.deleteById(id);
        return "redirect:/product/list";
    }
    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("name") String name){
        model.addAttribute("products",productService.findProductByName(name));
        model.addAttribute("name",name);
        return "view/product/list";
    }
    @GetMapping("/listPaging")
    public String showListPaging(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
        Page<Product> products =  productService.findAllPaging(PageRequest.of(page,2));
        model.addAttribute("products", products);
        return "view/product/listPaging";
    }
    @GetMapping("/searchPaging")
    public String showSearchPaging(Model model, @RequestParam("name") String name,@RequestParam(name = "page", defaultValue = "0") int page){
        Page<Product> products;
        if (name.isEmpty()){
            products = productService.findAllPaging(PageRequest.of(page,2));
        } else {
            products = productService.findProductByNamePaging(name,PageRequest.of(page,2) );
        }
        model.addAttribute("products",products);
        model.addAttribute("name",name);
        return "view/product/listPaging";
    }


}
