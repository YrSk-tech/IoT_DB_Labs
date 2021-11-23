package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.ReviewAgency;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class ReviewAgencyDao implements AbstractGenericDao<ReviewAgency> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<ReviewAgency> findAll() {
        List<ReviewAgency> reviewAgencies = new ArrayList<>();


        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reviewAgencies = session.createQuery("from ReviewAgency ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAgencies;
    }


    @Override
    public ReviewAgency findOne(Integer id) throws SQLException {
        ReviewAgency reviewAgency = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reviewAgency = session.get(ReviewAgency.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAgency;
    }

    @Override
    public void create(ReviewAgency reviewAgency) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(reviewAgency);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, ReviewAgency reviewAgency) throws SQLException  {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(reviewAgency);
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