package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.DiscountsDao;
import com.syvak.model.entity.Custom;
import com.syvak.model.entity.Discounts;

import java.sql.SQLException;
import java.util.List;

public class DiscountsController implements AbstractGenericController<Discounts> {
    private final DiscountsDao discountsDao = new DiscountsDao();


    @Override
    public List<Discounts> findAll() throws SQLException {
        return (List<Discounts>) discountsDao.findAll();
    }

    @Override
    public Discounts findOne(Integer id) throws SQLException {
        return discountsDao.findOne(id);
    }

    @Override
    public void create(Discounts adress) throws SQLException {
        discountsDao.create(adress);
    }

    @Override
    public void update(Integer id, Discounts adress) throws SQLException {
        if (discountsDao.findOne(id) == null){
            System.out.println("Discounts does not exist");
        } else {
            discountsDao.update(id, adress);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (discountsDao.findOne(id) == null){
            System.out.println("Discounts does not exist");
        } else {
            discountsDao.delete(id);
        }
    }
}