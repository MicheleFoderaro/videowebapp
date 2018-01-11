package com.videowebapp.dao.memory;

import com.videowebapp.dao.FilmDAO;
import com.videowebapp.model.Database;
import com.videowebapp.model.Film;



import java.util.List;

public class MemoryDAOFilmImpl implements FilmDAO {

    private static MemoryDAOFilmImpl instance;

    public synchronized static MemoryDAOFilmImpl getMemoryDAOImpl() {
        if (instance==null) {
            instance = new MemoryDAOFilmImpl();
        }
        return instance;
    }

    private MemoryDAOFilmImpl() {}

    @Override
    public List<Film> findAll() {
        return Database.getList();
    }

    @Override
    public void save(Film f) {
        Database.getList().add(f);
    }

    @Override
    public void update(Film f) {

    }

    @Override
    public void remove(Film f) {
    }

    @Override
    public Film findById(int id) {
        return null;
    }

}

