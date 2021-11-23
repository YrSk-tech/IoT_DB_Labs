package com.syvak.domain;

import javax.persistence.*;

@Entity
@Table(name = "review_animator")
public class ReviewAnimator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "animator_id", referencedColumnName = "id", nullable = false)
    private ReviewAnimator reviewAnimatorId;

    public ReviewAnimator(Integer id, String author, String text, ReviewAnimator reviewAnimatorId) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.reviewAnimatorId = reviewAnimatorId;
    }

    public ReviewAnimator(String author, String text, ReviewAnimator reviewAnimatorId) {
        this(null, author, text, reviewAnimatorId);
    }

    public ReviewAnimator() {
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

    public ReviewAnimator getReviewAnimatorId() {
        return reviewAnimatorId;
    }

    public void setReviewAnimatorId(ReviewAnimator reviewAnimatorId) {
        this.reviewAnimatorId = reviewAnimatorId;
    }

    @Override
    public String toString() {
        return "ReviewAnimator{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", reviewAnimatorId='" + reviewAnimatorId + '\'' +
                '}';
    }
}
