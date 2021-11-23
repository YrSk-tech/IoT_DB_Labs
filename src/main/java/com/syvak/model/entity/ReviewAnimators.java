package com.syvak.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "review_animator")
public class ReviewAnimators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;
    @Column(name = "animator_id")
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
    @Override
    public String toString() {
        return "ReviewAnimators{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", animator_id=" + animator_id +
                '}';
    }
}