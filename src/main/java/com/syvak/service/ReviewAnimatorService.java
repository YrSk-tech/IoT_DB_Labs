package com.syvak.service;

import com.syvak.domain.Discounts;
import com.syvak.domain.ReviewAnimator;
import com.syvak.repository.DiscountsRepository;
import com.syvak.repository.ReviewAnimatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewAnimatorService implements AbstractService<ReviewAnimator, Integer> {
    private final ReviewAnimatorRepository reviewAnimatorRepository;

    public ReviewAnimatorService(ReviewAnimatorRepository reviewAnimatorRepository) {
        this.reviewAnimatorRepository = reviewAnimatorRepository;
    }

    @Override
    public List<ReviewAnimator> getAll() {
        return reviewAnimatorRepository.findAll();
    }

    @Override
    public ReviewAnimator getById(Integer id) {
        return reviewAnimatorRepository.getOne(id);
    }

    @Override
    public ReviewAnimator create(ReviewAnimator animator) {
        return reviewAnimatorRepository.save(animator);
    }

    @Override
    public ReviewAnimator update(Integer id, ReviewAnimator animator) {
        if (reviewAnimatorRepository.findById(id).isPresent()) {
            return reviewAnimatorRepository.save(animator);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (reviewAnimatorRepository.findById(id).isPresent()) {
            reviewAnimatorRepository.deleteById(id);
        }
    }
}