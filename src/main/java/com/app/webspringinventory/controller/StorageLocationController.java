package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.StorageLocation;
import com.app.webspringinventory.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/storage-location")
public class StorageLocationController {
    @Autowired
    private StorageLocationService service;

    @GetMapping("")
    public ModelAndView get() {
        List<StorageLocation> list = service.get();
        return new ModelAndView("storage-location/index","storageLocations",list);
    }

    @GetMapping("/create")
    public String create() {
        return "storage-location/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute StorageLocation storageLocation) {
        service.save(storageLocation);
        return "redirect:/storage-location";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        StorageLocation storageLocation = service.getById(id);
        model.addAttribute("storageLocation", storageLocation);
        return "storage-location/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/storage-location";
    }
}
