package com.syvak.model.entity;

import java.util.Objects;

public class Agency {

    private Integer id;

    private String name;

    private Integer phone_number;

    public Agency(Integer id, String name, Integer phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public Agency(String name, Integer phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public Agency() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency password = (Agency) o;
        return Objects.equals(id, password.id) && Objects.equals(name, password.name) && Objects.equals(phone_number, password.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone_number);
    }

    @Override
    public String toString() {
        return "\n Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone_number=" + phone_number +
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

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }
}