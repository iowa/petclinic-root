package org.springframework.samples.petclinic.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.service.management.ManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ManagementController {
    @Autowired
    private ManagementService service;

    @GetMapping("/management/revenue")
    public String showRevenue(Map<String, Object> model) {
        model.put("revenues", service.listYearlyRevenue());
        return "management/showRevenue";
    }

}
