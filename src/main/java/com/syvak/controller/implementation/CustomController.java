package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.CustomDao;
import com.syvak.model.entity.Custom;

import java.sql.SQLException;
import java.util.List;

public class CustomController implements AbstractGenericController<Custom> {
    private final CustomDao customDao = new CustomDao();


    @Override
    public List<Custom> findAll() throws SQLException {
        return customDao.findAll();
    }

    @Override
    public Custom findOne(Integer id) throws SQLException {
        return customDao.findOne(id);
    }

    @Override
    public void create(Custom custom) throws SQLException {
        customDao.create(custom);
    }

    @Override
    public void update(Integer id, Custom custom) throws SQLException {
        if (customDao.findOne(id) == null){
            System.out.println("Custom does not exist");
        } else {
            customDao.update(id, custom);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (customDao.findOne(id) == null){
            System.out.println("Custom does not exist");
        } else {
            customDao.delete(id);
        }
    }
}