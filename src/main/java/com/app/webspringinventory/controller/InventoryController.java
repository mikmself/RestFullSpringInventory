package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.Inventory;
import com.app.webspringinventory.service.CustodianService;
import com.app.webspringinventory.service.InventoryService;
import com.app.webspringinventory.service.ItemService;
import com.app.webspringinventory.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StorageLocationService locationService;

    @Autowired
    private CustodianService custodianService;

    @GetMapping("")
    public ModelAndView getAllInventories() {
        List<Inventory> inventories = inventoryService.get();
        return new ModelAndView("inventory/index", "inventories", inventories);
    }

    @GetMapping("/create")
    public String createInventory(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("items", itemService.get());
        model.addAttribute("locations", locationService.get());
        model.addAttribute("custodians", custodianService.get());
        return "inventory/create";
    }

    @PostMapping("/store")
    public String storeInventory(@ModelAttribute Inventory inventory) {
        inventoryService.save(inventory);
        return "redirect:/inventory";
    }

    @GetMapping("/edit/{id}")
    public String editInventory(@PathVariable("id") int id, Model model) {
        Inventory inventory = inventoryService.getById(id);
        model.addAttribute("inventory", inventory);
        model.addAttribute("items", itemService.get());
        model.addAttribute("locations", locationService.get());
        model.addAttribute("custodians", custodianService.get());
        return "inventory/edit";
    }

    @PostMapping("/delete/{id}")
    public String deleteInventory(@PathVariable("id") int id) {
        inventoryService.deleteById(id);
        return "redirect:/inventory";
    }
}
