package com.videowebapp.dao.jpa;

import com.videowebapp.dao.FilmDAO;
import com.videowebapp.model.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JPADAOFilmImpl implements FilmDAO {

    private static JPADAOFilmImpl instance = new JPADAOFilmImpl();

    public static JPADAOFilmImpl getJPADAOFilmImpl() {
        return instance;
    }

    private JPADAOFilmImpl() {
    }

    @Override
    public List<Film> findAll() {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        List<Film> films = em.createQuery("SELECT f FROM Film f", Film.class).getResultList();
        em.close();
        return films;
    }

    @Override
    public void save(Film f) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(f);
        et.commit();
        em.close();
    }

    @Override
    public void update(Film f) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(f);
        et.commit();
        em.close();
    }

    @Override
    public void remove(Film f) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        f = em.merge(f);
        em.remove(f);
        et.commit();
        em.close();
    }

    @Override
    public Film findById(int id) {
        EntityManager em = JPADAOFactory.emf.createEntityManager();
        Film film = em.find(Film.class, id);
        return film;
    }
}
