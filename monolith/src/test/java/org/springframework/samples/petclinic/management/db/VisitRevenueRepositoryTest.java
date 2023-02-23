package org.springframework.samples.petclinic.management.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.management.model.YearlyRevenue;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VisitRevenueRepositoryTest {

    @Autowired
    VisitRevenueRepository visitRevenueRepository;

    @Test
    void testGenerateRevenueReport() {
        List<YearlyRevenue> yearlyRevenues = this.visitRevenueRepository.listYearlyRevenue();
        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0).getTotal()).isEqualTo(800L);
    }

}