package com.app.webspringinventory.controller;

import com.app.webspringinventory.entity.UsageHistory;
import com.app.webspringinventory.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UsageHistoryService usageHistoryService;

    @GetMapping("/")
    public ModelAndView index() {
        List<UsageHistory> usageHistories = usageHistoryService.get();
        return new ModelAndView("index", "usageHistories", usageHistories);
    }
}
