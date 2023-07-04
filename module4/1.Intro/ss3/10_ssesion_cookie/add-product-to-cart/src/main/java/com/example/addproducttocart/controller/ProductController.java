package com.example.addproducttocart.controller;

import com.example.addproducttocart.model.Cart;
import com.example.addproducttocart.model.Product;
import com.example.addproducttocart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@SessionAttributes("cart")
@Controller
//Annotation @SessionAttributes("cart") được sử dụng để lưu trữ model attribute trong session.
// Trong đoạn mã trên, model attribute "cart"  sẽ được thêm vào session nếu tên attribute của
// @ModelAttribute và @SessionAttributes giống nhau.
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        //isPresent()kt object có exist không
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

}
