package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.Animator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnimatorDao implements AbstractGenericDao<Animator> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();



    public Collection<Animator> findAll() {
        List<Animator> animator = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            animator = session.createQuery("from Animator ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animator;
    }


    @Override
    public Animator findOne(Integer id) throws SQLException {
        Animator animator = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            animator = session.get(Animator.class, id);
            session.getTransaction().commit();



        } catch (Exception e) {
            e.printStackTrace();
        }
        return animator;
    }

    @Override
    public void create(Animator animator) throws SQLException {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(animator);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Animator animator) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(animator);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Agency agency = session.get(Agency.class, id);
            if (agency != null) {
                session.delete(agency);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}