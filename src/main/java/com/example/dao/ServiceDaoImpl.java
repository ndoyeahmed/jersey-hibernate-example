package main.java.com.example.dao;

import main.java.com.example.config.HibernateConfiguration;
import main.java.com.example.models.Employe;
import main.java.com.example.models.Service;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ServiceDaoImpl implements IServiceDao {
    Session session = HibernateConfiguration.getSession();
    @Override
    public List<Service> all() {
        try {
            return session
                    .createQuery("select s from Service s", Service.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Service getById(Long id) {
        try {
            return session.createQuery("select s from Service s where s.id=:id", Service.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addEmploye(Employe employe) {
        try {
            session.beginTransaction();
            session.save(employe);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employe> allEmploye() {
        try {
            return session
                    .createQuery("select e from Employe e", Employe.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employe getEmployeById(Long id) {
        try {
            return session.createQuery("select e from Employe e where e.id=:id", Employe.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
