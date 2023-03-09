package org.springframework.samples.petclinic.owner.service.management;

import org.monolithic.petclinic.dto.VisitRevenueDTO;
import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.samples.petclinic.owner.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    private final ManagementRestClient restClient;
    private final JmsTemplate jmsTemplate;

    @Autowired
    public ManagementService(final ManagementRestClient restClient, final JmsTemplate jmsTemplate) {
        this.restClient = restClient;
        this.jmsTemplate = jmsTemplate;
    }

    public List<YearlyRevenueDTO> listYearlyRevenue() {
        return restClient.listYearlyRevenue();
    }

    public void save(final Visit visit) {
        VisitRevenueDTO dto = new VisitRevenueDTO(visit.getDate(), visit.getCost());
        jmsTemplate.convertAndSend("visit-save", dto);
    }

}
