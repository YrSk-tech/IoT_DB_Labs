package com.syvak.model.dao.implementation;

import com.syvak.model.entity.Agency;
import com.syvak.model.entity.Award;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.syvak.util.HibernateUtil;

import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AwardDao implements AbstractGenericDao<Award> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<Award> findAll() {
        List<Award> awards = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            awards = session.createQuery("from Award").getResultList();
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return awards;
    }


    @Override
    public Award findOne(Integer id) {
        Award award = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            award = session.get(Award.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return award;
    }

    @Override
    public void create(Award award) throws SQLException {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(award);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void update(Integer id, Award award) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(award);
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

