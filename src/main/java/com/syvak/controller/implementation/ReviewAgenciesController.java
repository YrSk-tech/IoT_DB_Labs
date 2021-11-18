package com.syvak.controller.implementation;


import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.ReviewAgencyDao;
import com.syvak.model.entity.ReviewAgency;

import java.sql.SQLException;
import java.util.List;
public class ReviewAgenciesController implements AbstractGenericController<ReviewAgency> {
    private final ReviewAgencyDao reviewAgenciesDao = new ReviewAgencyDao();


    @Override
    public List<ReviewAgency> findAll() throws SQLException {
        return reviewAgenciesDao.findAll();
    }

    @Override
    public ReviewAgency findOne(Integer id) throws SQLException {
        return reviewAgenciesDao.findOne(id);
    }

    @Override
    public void create(ReviewAgency reviewAgency) throws SQLException {
        reviewAgenciesDao.create(reviewAgency);
    }

    @Override
    public void update(Integer id, ReviewAgency reviewAgency) throws SQLException {
        if (reviewAgenciesDao.findOne(id) == null){
            System.out.println("review agency does not exist");
        } else {
            reviewAgenciesDao.update(id, reviewAgency);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (reviewAgenciesDao.findOne(id) == null){
            System.out.println("review agency does not exist");
        } else {
            reviewAgenciesDao.delete(id);
        }
    }
}
