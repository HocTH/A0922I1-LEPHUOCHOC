package com.example.testpass.restcontroller;

import com.example.testpass.entity.Product;
import com.example.testpass.service.CategoryService;
import com.example.testpass.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/delete")
    public ResponseEntity<Product> delete(@RequestParam("id") int id){
        productService.deleteById(id);
//        return new ResponseEntity<>("ok",HttpStatus.OK);
        return new ResponseEntity<Product>(new Product(), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Product>> getListProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
