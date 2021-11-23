package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.AwardDao;
import com.syvak.model.entity.Award;

import java.sql.SQLException;
import java.util.List;

public class AwardController implements AbstractGenericController<Award> {
    private final AwardDao awardDao = new AwardDao();


    @Override
    public List<Award> findAll() throws SQLException {
        return (List<Award>) awardDao.findAll();
    }

    @Override
    public Award findOne(Integer id) throws SQLException {
        return awardDao.findOne(id);
    }

    @Override
    public void create(Award award) throws SQLException {
        awardDao.create(award);
    }

    @Override
    public void update(Integer id, Award award) throws SQLException {
        if (awardDao.findOne(id) == null){
            System.out.println("Award does not exist");
        } else {
            awardDao.update(id, award);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (awardDao.findOne(id) == null){
            System.out.println("Award does not exist");
        } else {
            awardDao.delete(id);
        }
    }
}
