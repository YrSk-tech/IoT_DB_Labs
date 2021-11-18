package com.syvak.model.entity;

import java.util.Objects;

public class Discounts {

    private Integer id;

    private String name;

    private Float cost;

    private Integer agency_id;

    public Discounts(Integer id, String name, Float cost, Integer agency_id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.agency_id = agency_id;
    }

    public Discounts(String name, Float cost, Integer agency_id) {
        this.name = name;
        this.cost = cost;
        this.agency_id = agency_id;
    }

    public Discounts() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discounts discounts = (Discounts) o;
        return Objects.equals(id, discounts.id) && Objects.equals(name, discounts.name) && Objects.equals(cost, discounts.cost) && Objects.equals(agency_id, discounts.agency_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, agency_id);
    }

    @Override
    public String toString() {
        return "\nDiscounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", agency_id=" + agency_id +
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Integer agency_id) {
        this.agency_id = agency_id;
    }
}
