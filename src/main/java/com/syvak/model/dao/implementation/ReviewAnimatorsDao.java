package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.ReviewAnimators;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReviewAnimatorsDao implements AbstractGenericDao<ReviewAnimators> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public Collection<ReviewAnimators> findAll() {
        List<ReviewAnimators> reviewAnimators = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reviewAnimators = session.createQuery("FROM ReviewAnimators").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAnimators;
    }


    @Override
    public ReviewAnimators findOne(Integer id) throws SQLException {
        ReviewAnimators reviewAnimator = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reviewAnimator = session.get(ReviewAnimators.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewAnimator;
    }

    @Override
    public void create(ReviewAnimators reviewAnimator) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(reviewAnimator);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, ReviewAnimators reviewAnimator) throws SQLException {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(reviewAnimator);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
