package com.syvak.controller;


import com.syvak.domain.ReviewAnimator;
import com.syvak.dto.ReviewAnimatorDto;
import com.syvak.service.ReviewAnimatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/review_animator")
@RestController
public class ReviewAnimatorController {
    private final ReviewAnimatorService reviewAnimatorService;

    public ReviewAnimatorController(ReviewAnimatorService reviewAnimatorService) {
        this.reviewAnimatorService = reviewAnimatorService;
    }

    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<ReviewAnimatorDto>> getAll() {
        List<ReviewAnimator> reviewAnimators = reviewAnimatorService.getAll();
        List<ReviewAnimatorDto> reviewAnimatorDtos = new ArrayList<>();
        for (ReviewAnimator reviewAnimator : reviewAnimators) {
            ReviewAnimatorDto reviewAnimatorDto = new ReviewAnimatorDto(
                    reviewAnimator.getId(),
                    reviewAnimator.getAuthor(),
                    reviewAnimator.getText(),
                    reviewAnimator.getReviewAnimatorId()
            );
            reviewAnimatorDtos.add(reviewAnimatorDto);
        }
        return new ResponseEntity<>(reviewAnimatorDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ReviewAnimatorDto> getById(@PathVariable Integer id) {
        ReviewAnimator reviewAnimatorOld = reviewAnimatorService.getById(id);
        if (reviewAnimatorOld != null) {
            ReviewAnimatorDto reviewAnimatorDto = new ReviewAnimatorDto(
                    reviewAnimatorOld.getId(),
                    reviewAnimatorOld.getAuthor(),
                    reviewAnimatorOld.getText(),
                    reviewAnimatorOld.getReviewAnimatorId()
            );
            return new ResponseEntity<>(reviewAnimatorDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody ReviewAnimator newReviewAnimator) {
        reviewAnimatorService.create(newReviewAnimator);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReviewAnimatorDto> update(@PathVariable Integer id,
                                              @RequestBody ReviewAnimator reviewAnimator) {
        ReviewAnimator animatorOld = reviewAnimatorService.getById(id);
        if (animatorOld != null) {
            reviewAnimatorService.update(id, reviewAnimator);
            ReviewAnimatorDto reviewAnimatorOldDto = new ReviewAnimatorDto(
                    reviewAnimator.getId(),
                    reviewAnimator.getAuthor(),
                    reviewAnimator.getText(),
                    reviewAnimator.getReviewAnimatorId()
            );
            return new ResponseEntity<>(reviewAnimatorOldDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (reviewAnimatorService.getById(id) != null) {
            reviewAnimatorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
