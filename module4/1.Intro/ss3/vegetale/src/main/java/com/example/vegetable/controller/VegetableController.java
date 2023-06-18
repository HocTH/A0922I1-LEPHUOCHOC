package com.example.vegetable.controller;

import com.example.vegetable.entity.Vegetable;
import com.example.vegetable.service.Imp.TypeService;
import com.example.vegetable.service.Imp.VegetableServiceSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VegetableController {
    @Autowired
    private VegetableServiceSource vegetableServiceSource;
    @Autowired
    private TypeService typeService;
    @GetMapping("list")
    public String showList(Model model){
        model.addAttribute("vegetables",vegetableServiceSource.findAll());
        return "list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("vegetable", new Vegetable());
        model.addAttribute("types", typeService.findAll());
        return "create";
    }
    @PostMapping("create")
    public String doCreate(@ModelAttribute("vegetable") Vegetable vegetable){
        vegetable.setType(typeService.findById(vegetable.getType().getIdType()));
        vegetableServiceSource.create(vegetable);
        return "redirect:list";
    }
    @GetMapping("detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
        Vegetable vegetable = vegetableServiceSource.findById(id);
        model.addAttribute("vegetable", vegetable);
        return "detail";
    }
    @GetMapping("update")
    public String showUpdate(Model model, @RequestParam("id") int id){
        Vegetable vegetable = vegetableServiceSource.findById(id);
        model.addAttribute("vegetable", vegetable);
        model.addAttribute("types",typeService.findAll());
        return "update";
    }
    @PostMapping("update")
    public String doUpdate(@ModelAttribute("vegetable") Vegetable vegetable){
        vegetable.setType(typeService.findById(vegetable.getType().getIdType()));
        vegetableServiceSource.update(vegetable);
        return "redirect:list";
    }
}
