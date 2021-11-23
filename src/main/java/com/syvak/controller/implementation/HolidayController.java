package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.HolidayDao;
import com.syvak.model.entity.Discounts;
import com.syvak.model.entity.Holiday;

import java.sql.SQLException;
import java.util.List;

public class HolidayController implements AbstractGenericController<Holiday> {
    private final HolidayDao holidayDao = new HolidayDao();


    @Override
    public List<Holiday> findAll() throws SQLException {
        return (List<Holiday>) holidayDao.findAll();
    }

    @Override
    public Holiday findOne(Integer id) throws SQLException {
        return holidayDao.findOne(id);
    }

    @Override
    public void create(Holiday holiday) throws SQLException {
        holidayDao.create(holiday);
    }

    @Override
    public void update(Integer id, Holiday holiday) throws SQLException {
        if (holidayDao.findOne(id) == null){
            System.out.println("Holiday does not exist");
        } else {
            holidayDao.update(id, holiday);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (holidayDao.findOne(id) == null){
            System.out.println("Holiday does not exist");
        } else {
            holidayDao.delete(id);
        }
    }
}