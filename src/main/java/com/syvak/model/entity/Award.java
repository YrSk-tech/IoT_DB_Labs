package com.syvak.model.entity;

import java.util.Objects;

public class Award {
    private Integer id;

    private String name;

    private Integer year;

    private String nomination;

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

    public Award() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return Objects.equals(id, award.id) && Objects.equals(name, award.name) && Objects.equals(year, award.year) && Objects.equals(nomination, award.nomination) && Objects.equals(agencyId, award.agencyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, nomination, agencyId);
    }

    @Override
    public String toString() {
        return "\nAward{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", nomination='" + nomination + '\'' +
                ", agencyId=" + agencyId +
                '}';
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
}