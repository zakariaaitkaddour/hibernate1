package service;

import dao.IDao;
import entities.Machine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class MachineService implements IDao<Machine> {
    @Override
    public boolean create(Machine machine) {
        Session session = null;
        Transaction tx = null;
        boolean result = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(machine);
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
    public boolean update(Machine machine) {
        Session session = null;
        Transaction tx = null;
        boolean result = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(machine);
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
    public boolean delete(Machine machine) {
        Session session = null;
        Transaction tx = null;
        boolean result = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(machine);
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
    public List<Machine> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Machine> machines = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machines = session.createQuery("from Machine", Machine.class).list();
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
        return machines;
    }

    @Override
    public Machine findById(int id) {
        Session session = null;
        Transaction tx = null;
        Machine machine = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machine = session.get(Machine.class, id);
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
        return machine;
    }

    public List<Machine> findBetweenDate(Date d1, Date d2) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Machine> query = session.createNamedQuery("findBetweenDate", Machine.class);
            query.setParameter("d1", d1);
            query.setParameter("d2", d2);
            return query.getResultList();
        }
    }
}
