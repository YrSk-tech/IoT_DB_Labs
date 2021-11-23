package com.syvak.service;

import com.syvak.domain.Animator;
import com.syvak.domain.Discounts;
import com.syvak.repository.AnimatorRepository;
import com.syvak.repository.DiscountsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountsService implements AbstractService<Discounts, Integer> {

    private final DiscountsRepository discountsRepository;

    public DiscountsService(DiscountsRepository discountsRepository) {
        this.discountsRepository = discountsRepository;
    }

    @Override
    public List<Discounts> getAll() {
        return discountsRepository.findAll();
    }

    @Override
    public Discounts getById(Integer id) {
        return discountsRepository.getOne(id);
    }

    @Override
    public Discounts create(Discounts animator) {
        return discountsRepository.save(animator);
    }

    @Override
    public Discounts update(Integer id, Discounts animator) {
        if (discountsRepository.findById(id).isPresent()) {
            return discountsRepository.save(animator);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (discountsRepository.findById(id).isPresent()) {
            discountsRepository.deleteById(id);
        }
    }
}
