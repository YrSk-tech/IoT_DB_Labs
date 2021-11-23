package com.syvak.model.entity;

import org.apache.bcel.generic.RETURN;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "review_agency")
public class ReviewAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;
    @JoinColumn(name = "id")
    @ManyToOne
    private Agency agency;


    public ReviewAgency(Integer id, String author, String text, Agency agency) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.agency = agency;
    }

    public ReviewAgency(String author, String text, Agency agency) {
        this.author = author;
        this.text = text;
        this.agency = agency;
    }

    public ReviewAgency(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Integer getAgency(){
        return agency
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "\nReviewAgency{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", agency_id='" + agency + '\'' + '}';
    }
}