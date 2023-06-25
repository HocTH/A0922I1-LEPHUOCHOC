package com.example.blogpage.controller;

import com.example.blogpage.entity.Blog;
import com.example.blogpage.entity.Category;
import com.example.blogpage.service.BlogService;
import com.example.blogpage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BlogController {
    @Autowired
     private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    private ModelAndView showList(){
        List<Blog> blogs = blogService.findAll() ;
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs",blogs);
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "create";}
    @PostMapping("/create")
    public String doCreate(@Validated  @ModelAttribute("blog") Blog blog,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories",categoryService.findAll());
            return "create";
        }

        blogService.create(blog);
        return "redirect:/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
       blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        blogService.update(blog);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        blogService.delete(id);
        return "redirect:/list";
    }
    @GetMapping(value = "/listpaging")
    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size,
                             @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("name");
        Sort sortBy = Sort.by("author").descending().and(Sort.by("name").ascending());
        Page<Blog> blogs = blogService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        model.addAttribute("blogs", blogs);
        int totalPages = blogs.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "listpaging";
    }
    @GetMapping(value = "/listpagingslice")
    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Slice<Blog> blogs = blogService.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("blogs", blogs.getContent());
        model.addAttribute("page", blogs);
        return "listPagingSlice";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Blog> blogs = blogService.findBlogByName(name);
        model.addAttribute("blogs", blogs);
        model.addAttribute("name", name);
        return "list";
    }

    @GetMapping("/category/{id}")
    public String viewCategory(@PathVariable("id") int id, Model model){
        Category category = categoryService.findById(id);
        Iterable<Blog> blogs = blogService.findAllByCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("blogs", blogs);
       return "listCategory";
    }
}
