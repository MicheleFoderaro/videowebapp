package com.videowebapp.dao.memory;

import com.videowebapp.dao.FactoryDAO;
import com.videowebapp.dao.FilmDAO;
import com.videowebapp.dao.GenereDAO;
import com.videowebapp.dao.UtenteDAO;

public class MemoryDAOFactory extends FactoryDAO {

    private static MemoryDAOFactory instance;

    private MemoryDAOFactory(){}

    public static synchronized MemoryDAOFactory getInstance() {
        if (instance==null) {
            instance = new MemoryDAOFactory();
        }
        return instance;
    }

    public FilmDAO getFilmDAO() {
        return MemoryDAOFilmImpl.getMemoryDAOImpl();
    }

    @Override
    public GenereDAO getGenereDAO() {
        return null;
    }

    @Override
    public UtenteDAO getUtenteDAO() {
        return null;
    }
}
