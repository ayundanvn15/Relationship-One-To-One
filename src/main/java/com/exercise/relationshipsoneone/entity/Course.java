package com.exercise.relationshipsoneone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long idCourse;

    @Column(nullable = false)
    private String name;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }
}
