package org.springframework.samples.petclinic.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.management.db.VisitRevenueRepository;
import org.springframework.samples.petclinic.management.model.VisitRevenue;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;
import org.springframework.samples.petclinic.owner.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    private final VisitRevenueRepository repository;

    @Autowired
    public ManagementService(final VisitRevenueRepository repository) {
        this.repository = repository;
    }

    public List<YearlyRevenue> listYearlyRevenue() {
        return repository.listYearlyRevenue();
    }

    public void save(final Visit visit) {
        VisitRevenue visitRevenue = new VisitRevenue();
        visitRevenue.setDate(visit.getDate());
        visitRevenue.setCost(visit.getCost());
        repository.save(visitRevenue);
    }


}
