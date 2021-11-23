package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.Discounts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DiscountsDao implements AbstractGenericDao<Discounts> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();



    public Collection<Discounts> findAll() {
        List<Discounts> discounts = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            discounts = session.createQuery("from Discounts ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return discounts;
    }


    @Override
    public Discounts findOne(Integer id) {
        Discounts discount = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            discount = session.get(Discounts.class, id);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public void create(Discounts discount) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(discount);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Discounts discount) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(discount);
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