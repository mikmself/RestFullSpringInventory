package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.Custodian;
import com.app.webspringinventory.service.CustodianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/custodian")
public class CustodianController {

    @Autowired
    private CustodianService service;

    @GetMapping("")
    public ModelAndView get() {
        List<Custodian> list = service.get();
        return new ModelAndView("custodian/index","custodians",list);
    }

    @GetMapping("/create")
    public String create() {
        return "custodian/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Custodian custodian) {
        service.save(custodian);
        return "redirect:/custodian";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Custodian custodian = service.getById(id);
        model.addAttribute("custodian", custodian);
        return "custodian/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/custodian";
    }
}
