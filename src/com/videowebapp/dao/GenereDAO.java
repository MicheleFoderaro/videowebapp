package com.videowebapp.dao;

import com.videowebapp.model.Genere;

import java.util.HashMap;

public interface GenereDAO {
    public HashMap<Integer, Genere> findAll();
    public void save(Genere g);
    public void update(Genere g);
    public void remove(Genere g);
    public Genere findById(int id);
}
