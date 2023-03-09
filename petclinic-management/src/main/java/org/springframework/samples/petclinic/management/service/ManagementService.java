package org.springframework.samples.petclinic.management.service;

import org.monolithic.petclinic.dto.VisitRevenueDTO;
import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.samples.petclinic.management.db.VisitRevenueRepository;
import org.springframework.samples.petclinic.management.model.VisitRevenue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    private final VisitRevenueRepository repository;

    @Autowired
    public ManagementService(final VisitRevenueRepository repository) {
        this.repository = repository;
    }

    public List<YearlyRevenueDTO> listYearlyRevenue() {
        return repository.listYearlyRevenue();
    }

    @JmsListener(destination = "visit-save", containerFactory = "myFactory")
    public void receiveMessage(final VisitRevenueDTO dto) {
        repository.save(new VisitRevenue(dto.getDate(), dto.getCost()));
    }

}
