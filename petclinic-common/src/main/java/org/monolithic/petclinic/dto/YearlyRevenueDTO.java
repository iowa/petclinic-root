package org.monolithic.petclinic.dto;

public class YearlyRevenueDTO {

    private final Integer year;
    private final Long total;

    public YearlyRevenueDTO(Integer year, Long total) {
        this.year = year;
        this.total = total;
    }

    public Integer getYear() {
        return year;
    }

    public Long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "YearlyRevenue{" +
            "year=" + year +
            ", total=" + total +
            '}';
    }
}
