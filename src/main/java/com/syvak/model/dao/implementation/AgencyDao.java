package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AgencyDao implements AbstractGenericDao<Agency> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<Agency> findAll() {

        List<Agency> agency = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            agency = session.createQuery("from Agency ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return agency;
    }


    @Override
    public Agency findOne(Integer id) throws SQLException {
        Agency agency = null;


        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            agency = session.get(Agency.class, id);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return agency;
    }

    @Override
    public void create(Agency agency) throws SQLException {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(agency);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Agency agency) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(agency);
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
