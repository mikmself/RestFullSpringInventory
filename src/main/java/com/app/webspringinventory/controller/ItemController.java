package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.Item;
import com.app.webspringinventory.service.ItemCategoryService;
import com.app.webspringinventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @Autowired
    ItemCategoryService itemCategoryService;

    @GetMapping("")
    public ModelAndView get() {
        List<Item> list = service.get();
        return new ModelAndView("item/index","items",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("itemCategories", itemCategoryService.get());
        return "item/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Item item) {
        service.save(item);
        return "redirect:/item";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("itemCategories", itemCategoryService.get());
        Item item = service.getById(id);
        model.addAttribute("item", item);
        return "item/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/item";
    }
}
