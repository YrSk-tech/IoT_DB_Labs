package com.syvak.model.entity;

import java.util.Objects;

public class Animator {
    private Integer id;

    private String name;

    private String surname;

    private String last_name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animator animator = (Animator) o;
        return Objects.equals(id, animator.id) && Objects.equals(name, animator.name) && Objects.equals(surname, animator.surname) && Objects.equals(last_name, animator.last_name) && Objects.equals(age, animator.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, last_name, age);
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
}