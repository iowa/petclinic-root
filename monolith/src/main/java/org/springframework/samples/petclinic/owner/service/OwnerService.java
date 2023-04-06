package org.springframework.samples.petclinic.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.db.OwnerRepository;
import org.springframework.samples.petclinic.owner.model.Owner;
import org.springframework.samples.petclinic.pet.model.Pet;
import org.springframework.samples.petclinic.visit.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OwnerService {

    private final OwnerRepository owners;
    private final VisitService visitService;

    @Autowired
    public OwnerService(OwnerRepository owners, final VisitService visitService) {
        this.owners = owners;
        this.visitService = visitService;
    }

    public Collection<Owner> ownerByLastName(String lastName) {
        return owners.findByLastName(lastName);
    }

    public Owner ownerById(int i) {
        return owners.findById(i);
    }

    public void save(Owner owner) {
        owners.save(owner);
    }

    public Owner getOwnerWithPets(final int ownerId) {
        Owner owner = ownerById(ownerId);
        for (Pet pet : owner.getPets()) {
            pet.setVisitsInternal(visitService.visitsByPetId(pet.getId()));
        }
        return owner;
    }

}
