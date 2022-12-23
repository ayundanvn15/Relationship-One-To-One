package com.exercise.relationshipsoneone.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long idPassport;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    protected Passport() {
    }

    public Passport(String number) {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getIdPassport() {
        return idPassport;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
