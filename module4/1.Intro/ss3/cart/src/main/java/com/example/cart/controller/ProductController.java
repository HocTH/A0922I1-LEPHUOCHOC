package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    private CartDto initCart(){
        return new CartDto();
    }
    @Autowired
    private ProductService productService;
    @GetMapping
    public ModelAndView showListPage(Model model, @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                                     @CookieValue(value = "productId",required = false, defaultValue = "-1") int id){
        model.addAttribute("historyProduct", productService.findById(id));
        if (cartDto != null){
            model.addAttribute("cart", cartDto);
        }
        return new ModelAndView("product/list","productList", productService.findAll());
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response) {
        // tạo Cookie để lưu lịch sử xem sản phẩm gần nhất
        Cookie cookie = new Cookie("productId",id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("product/detail",
                "product", productService.findById(id));
    }
    // thêm mới vào giỏ hàng
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,@SessionAttribute(value = "cart")CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
