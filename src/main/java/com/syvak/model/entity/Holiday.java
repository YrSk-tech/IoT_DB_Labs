package com.syvak.model.entity;

import javax.persistence.*;
@Entity
@Table(name = "holiday")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "number_of_animators")
    private Integer number_of_animators;

    @Column(name = "number_of_participants")
    private Integer number_of_participants;

    @Column(name = "custom_id")
    private Integer custom_id;

    public Holiday(Integer id, String type, Integer number_of_animators, Integer number_of_participants, Integer custom_id) {
        this.id = id;
        this.type = type;
        this.number_of_animators = number_of_animators;
        this.number_of_participants = number_of_participants;
        this.custom_id = custom_id;
    }

    public Holiday(String type, Integer number_of_animators, Integer number_of_participants, Integer custom_id) {
        this.type = type;
        this.number_of_animators = number_of_animators;
        this.number_of_participants = number_of_participants;
        this.custom_id = custom_id;
    }

    public Holiday() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber_of_animators() {
        return number_of_animators;
    }

    public void setNumber_of_animators(Integer number_of_animators) {
        this.number_of_animators = number_of_animators;
    }

    public Integer getNumber_of_participants() {
        return number_of_participants;
    }

    public void setNumber_of_participants(Integer number_of_participants) {
        this.number_of_participants = number_of_participants;
    }

    public Integer getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(Integer custom_id) {
        this.custom_id = custom_id;
    }
    @Override
    public String toString() {
        return "\nHoliday{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number_of_animators=" + number_of_animators +
                ", number_of_participants=" + number_of_participants +
                ", custom_id=" + custom_id +
                '}';
    }

}
