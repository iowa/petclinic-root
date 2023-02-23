package org.springframework.samples.petclinic.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.db.RevenueRepository;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    private final RevenueRepository revenueRepository;

    @Autowired
    public ManagementService(final RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }

}
