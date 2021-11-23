package com.syvak.model.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "discounts")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Float cost;

    @Column(name = "agency_id")
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
    @Override
    public String toString() {
        return "\nDiscounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", agency_id=" + agency_id +
                '}';
    }


}
