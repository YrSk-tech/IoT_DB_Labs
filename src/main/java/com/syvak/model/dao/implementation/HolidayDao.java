package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.Holiday;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HolidayDao implements AbstractGenericDao<Holiday> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();



    public Collection<Holiday> findAll() {
        List<Holiday> holidays = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            holidays = session.createQuery("from Holiday ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return holidays;
    }


    @Override
    public Holiday findOne(Integer id) throws SQLException {
        Holiday holiday = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            holiday = session.get(Holiday.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return holiday;
    }

    @Override
    public void create(Holiday holiday) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(holiday);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Holiday holiday) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(holiday);
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
