package org.springframework.samples.petclinic.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.db.OwnerRepository;
import org.springframework.samples.petclinic.owner.db.PetRepository;
import org.springframework.samples.petclinic.owner.db.VisitRepository;
import org.springframework.samples.petclinic.owner.model.Owner;
import org.springframework.samples.petclinic.owner.model.Pet;
import org.springframework.samples.petclinic.owner.model.PetType;
import org.springframework.samples.petclinic.owner.model.Visit;
import org.springframework.samples.petclinic.pet.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClinicService {

    private final OwnerRepository owners;

    private final VisitRepository visits;

    @Autowired
    public ClinicService(
            OwnerRepository owners,
            VisitRepository visits
    ) {
        this.owners = owners;
        this.visits = visits;
    }


    public Collection<Owner> ownerByLastName(String lastName) {
        return owners.findByLastName(lastName);
    }

    public Owner ownerById(int i) {
        return owners.findById(i);
    }

    public List<Visit> visitsByPetId(int petId) {
        return visits.findByPetId(petId);
    }


    public void save(Owner owner) {
        owners.save(owner);
    }

    public void save(Visit visit) {
        visits.save(visit);
    }


}
