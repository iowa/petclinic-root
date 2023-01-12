package org.springframework.samples.petclinic.vet.service;

import org.monolithic.petclinic.dto.VetDTO;
import org.monolithic.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService {

    private final VetRepository vets;

    public VetService(final VetRepository vets) {
        this.vets = vets;
    }


    public List<VetDTO> allVetsDto() {
        return this.vets.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private VetDTO toDto(final Vet vet) {
        VetDTO vetDTO = new VetDTO();
        vetDTO.setFirstName(vet.getFirstName());
        vetDTO.setLastName(vet.getLastName());
        vetDTO.setSpecialties(vet.getSpecialties().stream().map(NamedEntity::getName).collect(Collectors.toSet()));
        return vetDTO;
    }

}
