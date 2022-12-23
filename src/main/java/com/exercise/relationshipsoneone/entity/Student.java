package com.exercise.relationshipsoneone.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long idStudent;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Passport passport;
    protected Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    @Override
    public String toString() {
        return String.format("Student[%s]", name);
    }
}
