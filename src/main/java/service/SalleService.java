package service;

import dao.IDao;
import entities.Salle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class SalleService implements IDao<Salle> {
    @Override
    public boolean create(Salle salle) {
        Session session = null;
        Transaction tx = null;
        boolean result = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(salle);
            tx.commit();
            result = true;
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public boolean update(Salle salle) {
        Session session = null;
        Transaction tx = null;
        boolean result = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(salle);
            tx.commit();
            result = true;
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public boolean delete(Salle salle) {
        Session session = null;
        Transaction tx = null;
        boolean result = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(salle);
            tx.commit();
            result = true;
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<Salle> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Salle> salles = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles = session.createQuery("from Salle", Salle.class).list();
            tx.commit();
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return salles;
    }

    @Override
    public Salle findById(int id) {
        Session session = null;
        Transaction tx = null;
        Salle salle = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle = session.get(Salle.class, id);
            tx.commit();
        }catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return salle;
    }
}
