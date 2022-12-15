package org.springframework.samples.petclinic.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
class ManagementController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/management/revenue")
    public String showRevenue(Map<String, Object> model) {
        model.put("revenues", clinicService.listYearlyRevenue());
        return "management/showRevenue";
    }

}
