package com.videowebapp.dao.jpa;

import com.videowebapp.dao.FactoryDAO;
import com.videowebapp.dao.FilmDAO;
import com.videowebapp.dao.GenereDAO;
import com.videowebapp.dao.UtenteDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactory extends FactoryDAO {

    private static JPADAOFactory instance = new JPADAOFactory();

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL_videowebapp");

    private JPADAOFactory() {}

    public static JPADAOFactory getJPADAOFactory() {
        if (instance==null) {
            instance = new JPADAOFactory();
        }
        return instance;
    }

    @Override
    public FilmDAO getFilmDAO() {
        return JPADAOFilmImpl.getJPADAOFilmImpl();
    }

    @Override
    public GenereDAO getGenereDAO() {
        return JPADAOGenereImpl.getJPADAOGenereImpl();
    }

    @Override
    public UtenteDAO getUtenteDAO() {
        return JPADAOUtenteImpl.getJPADAOUtenteImpl();
    }

}
