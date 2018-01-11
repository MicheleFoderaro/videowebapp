package com.videowebapp.dao.jpa;

import com.videowebapp.dao.GenereDAO;
import com.videowebapp.model.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.List;

public class JPADAOGenereImpl implements GenereDAO {

    private static JPADAOGenereImpl instance = new JPADAOGenereImpl();

    public synchronized static JPADAOGenereImpl getJPADAOGenereImpl() {
        return instance;
    }

    private JPADAOGenereImpl() {
    }

    @Override
    public HashMap<Integer, Genere> findAll() {

        EntityManager em = JPADAOFactory.emf.createEntityManager();
        HashMap<Integer, Genere> genereHashMap = new HashMap<>();
        List<Genere> generi = em.createQuery("SELECT g FROM Genere g", Genere.class).getResultList();
        for (Genere g : generi) {
            genereHashMap.put(g.getId(), g);
        }
        return genereHashMap;
    }

    @Override
    public void save(Genere g) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(g);
        et.commit();
        em.close();
    }

    @Override
    public void update(Genere g) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(g);
        et.commit();
        em.close();
    }

    @Override
    public void remove(Genere g) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        g = em.merge(g);
        em.remove(g);
        et.commit();
        em.close();
    }

    @Override
    public Genere findById(int id) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        Genere genere = em.find(Genere.class, id);
        return genere;
    }

}
