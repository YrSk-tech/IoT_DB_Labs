package com.syvak.model.entity;

import java.util.Objects;

public class ReviewAnimators {
    private Integer id;

    private String author;

    private String text;

    private Integer animator_id;

    public ReviewAnimators(Integer id, String author, String text, Integer animator_id) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.animator_id = animator_id;
    }

    public ReviewAnimators(String author, String text, Integer animator_id) {
        this.author = author;
        this.text = text;
        this.animator_id = animator_id;
    }

    public ReviewAnimators() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewAnimators that = (ReviewAnimators) o;
        return Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(text, that.text) && Objects.equals(animator_id, that.animator_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, animator_id);
    }

    @Override
    public String toString() {
        return "ReviewAnimators{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", animator_id=" + animator_id +
                '}';
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

    public Integer getAnimator_id() {
        return animator_id;
    }

    public void setAnimator_id(Integer animator_id) {
        this.animator_id = animator_id;
    }
}