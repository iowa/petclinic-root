package org.springframework.samples.petclinic.visit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.visit.db.VisitRepository;
import org.springframework.samples.petclinic.visit.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    private final VisitRepository visits;

    @Autowired
    public VisitService(final VisitRepository visits) {
        this.visits = visits;
    }

    public void save(Visit visit) {
        visits.save(visit);
    }

    public List<Visit> visitsByPetId(int petId) {
        return visits.findByPetId(petId);
    }

}
