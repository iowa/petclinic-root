package org.springframework.samples.petclinic.management.model;

import org.monolithic.petclinic.model.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "visits_revenue")
public class VisitRevenue extends BaseEntity {

    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column
    private Integer cost;

    public VisitRevenue() {
    }

    public VisitRevenue(final LocalDate date, final Integer cost) {
        this.date = date;
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(final Integer cost) {
        this.cost = cost;
    }

}
