package org.springframework.samples.petclinic.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.db.PetRepository;
import org.springframework.samples.petclinic.pet.model.Pet;
import org.springframework.samples.petclinic.pet.model.PetType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository pets;

    @Autowired
    public PetService(final PetRepository pets) {
        this.pets = pets;
    }

    public Pet petById(int id) {
        return pets.findById(id);
    }

    public void save(Pet pet) {
        pets.save(pet);
    }

    public List<PetType> petTypes() {
        return pets.findPetTypes();
    }
}
