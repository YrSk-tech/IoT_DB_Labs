package com.syvak.model.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "agency")
public class Animator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private Integer age;

    public Animator(Integer id, String name, String surname, String last_name, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.last_name = last_name;
        this.age = age;
    }

    public Animator(String name, String surname, String last_name, Integer age) {
        this.name = name;
        this.surname = surname;
        this.last_name = last_name;
        this.age = age;
    }

    public Animator() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "\n Animator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                '}';
    }
}