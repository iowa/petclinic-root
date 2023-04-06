package org.springframework.samples.petclinic.owner.service.vet;

import org.monolithic.petclinic.dto.VetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService {

    @Autowired
    private VetRestClient vetRestClient;

    public VetService(final VetRestClient vetRestClient) {
        this.vetRestClient = vetRestClient;
    }


    public List<VetDTO> allVetsDto() {
        return vetRestClient.allVetsDto();
    }

}
