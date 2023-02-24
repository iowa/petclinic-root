package org.springframework.samples.petclinic.owner.service.management;


import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ManagementRestClient {

    public static final String PATH = "/management/revenue";
    @Value("${management-service.url}")
    String serviceUrl;

    public List<YearlyRevenueDTO> listYearlyRevenue() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<YearlyRevenueDTO>> exchange = restTemplate.exchange(serviceUrl + PATH, HttpMethod.GET, null, new ParameterizedTypeReference<List<YearlyRevenueDTO>>() {
        });
        return exchange.getBody();
    }

}
