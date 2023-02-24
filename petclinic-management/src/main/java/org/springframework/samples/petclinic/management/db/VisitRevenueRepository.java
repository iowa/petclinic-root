package org.springframework.samples.petclinic.management.db;

import org.monolithic.petclinic.dto.YearlyRevenueDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.management.model.VisitRevenue;

import java.util.List;

/**
 * Query reports of revenue.
 */
public interface VisitRevenueRepository extends Repository<VisitRevenue, Integer> {

    @Query("Select new org.monolithic.petclinic.dto.YearlyRevenueDTO(YEAR(v.date), sum(v.cost)) " +
            "from VisitRevenue v " +
            "group by YEAR(v.date)")
    List<YearlyRevenueDTO> listYearlyRevenue();

    void save(VisitRevenue visit) throws DataAccessException;

}
