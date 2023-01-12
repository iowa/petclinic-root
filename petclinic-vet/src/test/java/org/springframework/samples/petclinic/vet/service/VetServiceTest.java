package org.springframework.samples.petclinic.vet.service;

import org.junit.jupiter.api.Test;
import org.monolithic.petclinic.dto.VetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vet.db.VetRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VetServiceTest {

    @Autowired
    VetService vetService;

    @Test
    void allVetsDto() {
        List<VetDTO> dtos = vetService.allVetsDto();

        assertThat(dtos).hasSize(6);

        assertThat(dtos.get(0).getFirstName()).isEqualTo("James");
        assertThat(dtos.get(0).getLastName()).isEqualTo("Carter");
    }
}