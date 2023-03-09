package org.monolithic.petclinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.time.LocalDate;

public class VisitRevenueDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column
    private Integer cost;

    public VisitRevenueDTO() {
    }

    public VisitRevenueDTO(final LocalDate date, final Integer cost) {
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
