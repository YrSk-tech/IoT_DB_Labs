package com.syvak.controller.implementation;

import com.syvak.controller.AbstractGenericController;
import com.syvak.model.dao.implementation.AnimatorDao;
import com.syvak.model.entity.Animator;

import java.sql.SQLException;
import java.util.List;

public class AnimatorController implements AbstractGenericController<Animator> {
    private final AnimatorDao animatorDao = new AnimatorDao();


    @Override
    public List<Animator> findAll() throws SQLException {
        return animatorDao.findAll();
    }

    @Override
    public Animator findOne(Integer user_id) throws SQLException {
        return animatorDao.findOne(user_id);
    }

    @Override
    public void create(Animator animator) throws SQLException {
        animatorDao.create(animator);
    }

    @Override
    public void update(Integer user_id, Animator animator) throws SQLException {
        if (animatorDao.findOne(user_id) == null){
            System.out.println("Animator does not exist");
        } else {
            animatorDao.update(user_id, animator);
        }
    }

    @Override
    public void delete(Integer user_id) throws SQLException {
        if (animatorDao.findOne(user_id) == null){
            System.out.println("Animator does not exist");
        } else {
            animatorDao.delete(user_id);
        }
    }
}