package org.springframework.samples.petclinic.management.controller;

import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.service.ManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagementController {
    @Autowired
    private ManagementService service;

    @GetMapping("/management/revenue")
    public List<YearlyRevenueDTO> showRevenue() {
        return service.listYearlyRevenue();
    }

}
