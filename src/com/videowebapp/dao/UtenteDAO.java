package com.videowebapp.dao;

import com.videowebapp.model.Utente;
import java.util.HashMap;
import java.util.List;

public interface UtenteDAO {
    public void save(Utente u);
    public void update(Utente u);
    public void remove(Utente u);
    public Utente findById(int id);
    public List<Utente> findAll();
}
