package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.ItemCategory;
import com.app.webspringinventory.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/item-category")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService service;

    @GetMapping("")
    public ModelAndView get() {
        List<ItemCategory> list = service.get();
        return new ModelAndView("item-category/index","itemCategories",list);
    }

    @GetMapping("/create")
    public String create() {
        return "item-category/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute ItemCategory itemCategory) {
        service.save(itemCategory);
        return "redirect:/item-category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        ItemCategory itemCategory = service.getById(id);
        model.addAttribute("itemCategory", itemCategory);
        return "item-category/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/item-category";
    }
}
