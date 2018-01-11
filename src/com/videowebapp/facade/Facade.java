package com.videowebapp.facade;

import com.videowebapp.dao.UtenteDAO;
import com.videowebapp.dao.dto.FilmDTO;
import com.videowebapp.dao.dto.UtenteDTO;
import com.videowebapp.model.Film;
import com.videowebapp.model.Genere;

import java.util.HashMap;
import java.util.List;

public interface Facade {
    public List<FilmDTO> getFilms();
    public FilmDTO getFilm(int id);
    public HashMap<Integer, Genere> getGeneri();
    public void saveFilm(FilmDTO f);
    public void deleteFilm(int id);
    public void updateFilm(FilmDTO f);
    public List<UtenteDTO> getUtenti();
    public UtenteDTO getUtente(int id);
    public void saveUtente(UtenteDTO u);
    public void deleteUtente(int id);
    public void updateUtente(UtenteDTO u);
}
