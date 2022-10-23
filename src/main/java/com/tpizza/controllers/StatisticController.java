package com.tpizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tpizza.service.StatisticService;

@Controller
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
 
    @GetMapping("/admin/turnover")
    public String getTurnover(Model model) {

        model.addAttribute("totalBillsByDay", this.statisticService.getTotalBillsByDay(7));
        model.addAttribute("totalBillsByMonth", this.statisticService.getBillsByMonth());
        return "turnover";
    }
}
