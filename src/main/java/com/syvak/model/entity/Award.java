package com.syvak.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "award")
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

    @Column(name = "nomination")
    private String nomination;

    @Column(name = "agency_id")
    private Integer agencyId;


    public Award(Integer id, String name, Integer year, String nomination, Integer agencyId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.nomination = nomination;
        this.agencyId = agencyId;
    }

    public Award(String name, Integer year, String nomination, Integer agencyId) {
        this.name = name;
        this.year = year;
        this.nomination = nomination;
        this.agencyId = agencyId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "\n Award{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", year=" + year +
             ", nomination='" + nomination + '\'' +
             ", agencyId=" + agencyId +
             '}';
 }
}