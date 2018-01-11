package com.videowebapp.dao.jpa;

import com.videowebapp.dao.UtenteDAO;
import com.videowebapp.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JPADAOUtenteImpl implements UtenteDAO {

    private static JPADAOUtenteImpl instance = new JPADAOUtenteImpl();

    public synchronized static JPADAOUtenteImpl getJPADAOUtenteImpl() {
        return instance;
    }

    private JPADAOUtenteImpl() {
    }

    @Override
    public void save(Utente u) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(u);
        et.commit();
        em.close();
    }

    @Override
    public void update(Utente u) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(u);
        et.commit();
        em.close();
    }

    @Override
    public void remove(Utente u) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        u = em.merge(u);
        em.remove(u);
        et.commit();
        em.close();
    }

    @Override
    public Utente findById(int id) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        Utente utente = em.find(Utente.class, id);
        return utente;
    }

    @Override
    public List<Utente> findAll() {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        List<Utente> utenti = em.createNamedQuery("Utente.findAll").getResultList();
        em.close();
        return utenti;
    }
}
