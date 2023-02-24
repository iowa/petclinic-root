package org.springframework.samples.petclinic.management.db;

import org.junit.jupiter.api.Test;
import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VisitRevenueRepositoryTest {

    @Autowired
    VisitRevenueRepository visitRevenueRepository;

    @Test
    void testGenerateRevenueReport() {
        List<YearlyRevenueDTO> yearlyRevenues = this.visitRevenueRepository.listYearlyRevenue();
        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0).getTotal()).isEqualTo(800L);
    }

}