package com.syvak.dto;

import com.syvak.domain.ReviewAnimator;

public class ReviewAnimatorDto {
    private Integer id;
    private String author;
    private String text;
    private ReviewAnimator reviewAnimatorId;

    public ReviewAnimatorDto(Integer id, String author, String text, ReviewAnimator reviewAnimatorId) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.reviewAnimatorId = reviewAnimatorId;
    }

    public ReviewAnimatorDto(String author, String text, ReviewAnimator reviewAnimatorId) {
        this.author = author;
        this.text = text;
        this.reviewAnimatorId = reviewAnimatorId;
    }

    public ReviewAnimatorDto() {
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

}
