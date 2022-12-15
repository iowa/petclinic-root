package org.monolithic.petclinic.dto;

import java.util.Set;

public class VetDTO {

    private String firstName;
    private String lastName;
    private Set<String> specialties;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Set<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(final Set<String> specialties) {
        this.specialties = specialties;
    }
}
