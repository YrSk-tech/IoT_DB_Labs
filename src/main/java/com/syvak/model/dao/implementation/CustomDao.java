package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.Custom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomDao implements AbstractGenericDao<Custom> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public Collection<Custom> findAll() {
        List<Custom> customs = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            customs = session.createQuery("from Custom ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customs;
    }


    @Override
    public Custom findOne(Integer id) {
        Custom custom = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            custom = session.get(Custom.class, id);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return custom;
    }

    @Override
    public void create(Custom custom) throws SQLException {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(custom);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Custom custom) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(custom);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Custom custom = session.get(Custom.class, id);
            if (custom != null) {
                session.delete(custom);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}