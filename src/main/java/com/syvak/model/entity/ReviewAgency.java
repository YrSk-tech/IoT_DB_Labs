package com.syvak.model.entity;

import java.util.Objects;

public class ReviewAgency {
    private Integer id;

    private String author;

    private String text;

    private Integer agency_id;


    public ReviewAgency(Integer id, String author, String text, Integer agency_id) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.agency_id = agency_id;
    }

    public ReviewAgency(String author, String text, Integer agency_id) {
        this.author = author;
        this.text = text;
        this.agency_id = agency_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewAgency comments = (ReviewAgency) o;
        return Objects.equals(id, comments.id) &&
                Objects.equals(author, comments.author) &&
                Objects.equals(text, comments.text) &&
                Objects.equals(agency_id, comments.agency_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, agency_id);
    }

    @Override
    public String toString() {
        return "\nReviewAgency{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", agency_id=" + agency_id + '}';
    }

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

    public Integer getAgencyId() {
        return agency_id;
    }

    public void setAgencyId(Integer agency_id) {
        this.agency_id = agency_id;
    }
}