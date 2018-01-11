package com.videowebapp.dao;

import com.videowebapp.model.Film;

import java.sql.ResultSet;
import java.util.List;

public interface FilmDAO {
    public List<Film> findAll();
    public void save(Film f);
    public void update(Film f);
    public void remove(Film f);
    public Film findById(int id);
}
