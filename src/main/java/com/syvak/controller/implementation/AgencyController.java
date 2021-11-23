package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.AgencyDao;
import com.syvak.model.entity.Agency;
import com.syvak.model.entity.Award;

import java.sql.SQLException;
import java.util.List;

public class AgencyController implements AbstractGenericController<Agency> {
    private final AgencyDao agencyDao = new AgencyDao();

    @Override
    public List<Agency> findAll() throws SQLException {
        return (List<Agency>) agencyDao.findAll();
    }

    @Override
    public Agency findOne(Integer id) throws SQLException {
        return agencyDao.findOne(id);
    }

    @Override
    public void create(Agency agency) throws SQLException {
        agencyDao.create(agency);
    }

    @Override
    public void update(Integer id, Agency agency) throws SQLException {
        if (agencyDao.findOne(id) == null){
            System.out.println("Agency does not exist");
        } else {
            agencyDao.update(id, agency);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        if (agencyDao.findOne(id) == null){
            System.out.println("Agency does not exist");
        } else {
            agencyDao.delete(id);
        }
    }
}
