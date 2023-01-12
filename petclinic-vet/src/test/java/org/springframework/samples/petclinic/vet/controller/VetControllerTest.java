package org.springframework.samples.petclinic.vet.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.monolithic.petclinic.dto.VetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.vet.service.VetService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VetControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VetService service;

    @Test
    public void getVets() throws Exception {
        Mockito.when(service.allVetsDto()).thenReturn(getVetDTOS());

        mockMvc.perform(MockMvcRequestBuilders.get("/vets"))
                .andExpect(status().isOk());
    }

    private ArrayList<VetDTO> getVetDTOS() {
        ArrayList<VetDTO> dtos = new ArrayList<>();
        VetDTO vet = new VetDTO();
        vet.setFirstName("Zaphod");
        vet.setLastName("Beeblebrox");
        dtos.add(vet);
        return dtos;
    }

}