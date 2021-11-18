package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.ReviewAnimatorsDao;
import com.syvak.model.entity.ReviewAnimators;

import java.sql.SQLException;
import java.util.List;

public class ReviewAnimatorsController implements AbstractGenericController<ReviewAnimators> {
    private final ReviewAnimatorsDao reviewAnimatorsDao = new ReviewAnimatorsDao();

    @Override
    public List<ReviewAnimators> findAll() throws SQLException {
        return reviewAnimatorsDao.findAll();
    }

    @Override
    public ReviewAnimators findOne(Integer id) throws SQLException {
        return reviewAnimatorsDao.findOne(id);
    }

    @Override
    public void create(ReviewAnimators reviewAnimators) throws SQLException {
        reviewAnimatorsDao.create(reviewAnimators);
    }

    @Override
    public void update(Integer id, ReviewAnimators reviewAnimators) throws SQLException {
        if (reviewAnimatorsDao.findOne(id) == null){
            System.out.println("ReviewAnimators does not exist");
        } else {
            reviewAnimatorsDao.update(id, reviewAnimators);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (reviewAnimatorsDao.findOne(id) == null){
            System.out.println("ReviewAnimators does not exist");
        } else {
            reviewAnimatorsDao.delete(id);
        }
    }
}