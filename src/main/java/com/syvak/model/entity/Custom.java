package com.syvak.model.entity;

import java.util.Objects;

public class Custom {

    private Integer id;

    private String date;

    private Integer duration_in_hours;

    private String address;

    private Integer cost_in_uah;

    public Custom(Integer id, String date, Integer duration_in_hours, String address, Integer cost_in_uah) {
        this.id = id;
        this.date = date;
        this.duration_in_hours = duration_in_hours;
        this.address = address;
        this.cost_in_uah = cost_in_uah;
    }

    public Custom(String date, Integer duration_in_hours, String address, Integer cost_in_uah) {
        this.date = date;
        this.duration_in_hours = duration_in_hours;
        this.address = address;
        this.cost_in_uah = cost_in_uah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Custom custom = (Custom) o;
        return Objects.equals(id, custom.id) && Objects.equals(date, custom.date) && Objects.equals(duration_in_hours, custom.duration_in_hours) && Objects.equals(address, custom.address) && Objects.equals(cost_in_uah, custom.cost_in_uah);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, duration_in_hours, address, cost_in_uah);
    }

    @Override
    public String toString() {
        return "\n Custom{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", duration_in_hours=" + duration_in_hours +
                ", address='" + address + '\'' +
                ", cost_in_uah=" + cost_in_uah +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDuration_in_hours() {
        return duration_in_hours;
    }

    public void setDuration_in_hours(Integer duration_in_hours) {
        this.duration_in_hours = duration_in_hours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCost_in_uah() {
        return cost_in_uah;
    }

    public void setCost_in_uah(Integer cost_in_uah) {
        this.cost_in_uah = cost_in_uah;
    }
}