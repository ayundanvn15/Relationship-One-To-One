package com.exercise.relationshipsoneone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long idPassport;

    @Column(nullable = false)
    private String number;

    protected Passport() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(Long idPassport) {
        this.idPassport = idPassport;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
