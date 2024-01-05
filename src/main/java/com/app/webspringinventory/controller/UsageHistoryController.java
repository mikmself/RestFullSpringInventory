package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.UsageHistory;
import com.app.webspringinventory.service.InventoryService;
import com.app.webspringinventory.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usage-history")
public class UsageHistoryController {
    @Autowired
    private UsageHistoryService service;

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("")
    public ModelAndView get() {
        List<UsageHistory> list = service.get();
        return new ModelAndView("usage-history/index","usageHistories",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("inventories",inventoryService.get());
        return "usage-history/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute UsageHistory usageHistory) {
        service.save(usageHistory);
        return "redirect:/usage-history";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        UsageHistory usageHistory = service.getById(id);
        model.addAttribute("usageHistory", usageHistory);
        model.addAttribute("inventories",inventoryService.get());
        return "usage-history/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/usage-history";
    }
}
