package codegym.vn.controller;

import codegym.vn.entity.Product;
import codegym.vn.service.CategoryService;
import codegym.vn.service.ProductService;
import codegym.vn.validate.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productRepository;
    @Autowired
    private CategoryService categoryRepository;
    @Autowired
    private ProductValidate validate;
    @GetMapping("/list")
    public String showList(@CookieValue(value = "count", defaultValue = "0") int count,
                           Model model, HttpServletResponse response,
                           HttpSession httpSession) {
//        String username = (String) httpSession.getAttribute("user");
//        if (username == null || username.equals("")) {
//            return "redirect:/login";
//        }

        Cookie cookie = new Cookie("count", ++count + "");
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        model.addAttribute("count", count);
        model.addAttribute("products", productRepository.findAll());
        return "/view/product/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "/view/product/create";
    }

    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("product") Product product,
            BindingResult bindingResult, Model model) {
        validate.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "/view/product/create";
        }
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "/view/product/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "/view/product/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = productRepository.findProductByName(name);
        model.addAttribute("products", productList);
        model.addAttribute("name", name);
        return "/view/product/list";
    }

    @ExceptionHandler(SQLException.class)
    public String handleError(SQLException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "errorPage";
    }
}
