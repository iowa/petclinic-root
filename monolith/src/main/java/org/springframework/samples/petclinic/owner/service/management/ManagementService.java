package org.springframework.samples.petclinic.owner.service.management;

import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {
    @Autowired
    private ManagementRestClient restClient;

    public ManagementService(final ManagementRestClient restClient) {
        this.restClient = restClient;
    }

    public List<YearlyRevenueDTO> listYearlyRevenue() {
        return restClient.listYearlyRevenue();
    }

    public void save(final Visit visit) {

    }
}
