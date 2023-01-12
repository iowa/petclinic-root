package org.springframework.samples.petclinic.owner.service;


import org.monolithic.petclinic.dto.VetDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VetRestClient {

    public static final String VETS_PATH = "/vets";

    @Value("${vet-service.url}")
    String vetServiceUrl;

    public List<VetDTO> allVetsDto() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<VetDTO>> exchange = restTemplate.exchange(vetServiceUrl + VETS_PATH, HttpMethod.GET, null, new ParameterizedTypeReference<List<VetDTO>>() {
        });
        return exchange.getBody();
    }

}
