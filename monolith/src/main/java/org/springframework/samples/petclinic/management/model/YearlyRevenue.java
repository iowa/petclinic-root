package org.springframework.samples.petclinic.management.model;

public class YearlyRevenue {

    private final Integer year;
    private final Long total;

    public YearlyRevenue(Integer year, Long total) {
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
