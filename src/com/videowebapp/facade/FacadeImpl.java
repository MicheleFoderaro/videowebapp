package com.videowebapp.facade;

import com.videowebapp.dao.FactoryDAO;
import com.videowebapp.dao.FilmDAO;
import com.videowebapp.dao.UtenteDAO;
import com.videowebapp.dao.dto.DTOAssembler;
import com.videowebapp.dao.dto.FilmDTO;
import com.videowebapp.dao.dto.UtenteDTO;
import com.videowebapp.model.Film;
import com.videowebapp.model.Genere;
import com.videowebapp.model.Utente;

import java.util.HashMap;
import java.util.List;

public class FacadeImpl implements Facade {

    private static FacadeImpl instance = new FacadeImpl();
    private static FactoryDAO factory = FactoryDAO.getFactoryDAO(FactoryDAO.JPA);

    private FacadeImpl() {
    }

    public static FacadeImpl getInstance() {
        return instance;
    }

    @Override
    public List<FilmDTO> getFilms() {
        return DTOAssembler.linkFilmGenere(factory.getFilmDAO().findAll(), getGeneri());
    }

    @Override
    public FilmDTO getFilm(int id) {
        return DTOAssembler.linkOneFilmToGenere(factory.getFilmDAO().findById(id), factory.getGenereDAO().findAll());
    }

    @Override
    public HashMap<Integer, Genere> getGeneri() {
        return factory.getGenereDAO().findAll();
    }

    @Override
    public void saveFilm(FilmDTO f) {
        FilmDAO db = factory.getFilmDAO();
        db.save(new Film(f.getTitle(), f.getId_genere(), f.getYear(), f.getCast(), f.getPathCopertina(), f.getRegista(), f.getDurata(), f.getDescrizione()));
    }

    @Override
    public void deleteFilm(int id) {
        Film f = factory.getFilmDAO().findById(id);
        factory.getFilmDAO().remove(f);
    }

    @Override
    public void updateFilm(FilmDTO f) {
        Film film = new Film(f.getTitle(), f.getId_genere(), f.getYear(), f.getRegista(),f.getCast(), f.getPathCopertina(), f.getDurata(), f.getDescrizione());
        film.setId(f.getId());
        factory.getFilmDAO().update(film);
    }

    @Override
    public List<UtenteDTO> getUtenti() {
        return DTOAssembler.linkUtente(factory.getUtenteDAO().findAll());
    }

    @Override
    public UtenteDTO getUtente(int id) {
        return DTOAssembler.linkOneUtente(factory.getUtenteDAO().findById(id));
    }


    @Override
    public void saveUtente(UtenteDTO u) {
        UtenteDAO db = factory.getUtenteDAO();
        db.save(new Utente(u.getEmail(), u.getPassword(), u.getRuolo(), u.isAttivo()));
    }

    @Override
    public void deleteUtente(int id) {
        Utente u = factory.getUtenteDAO().findById(id);
        factory.getUtenteDAO().remove(u);
    }

    @Override
    public void updateUtente(UtenteDTO u) {
        Utente utente = new Utente(u.getEmail(), u.getPassword(), u.getRuolo(), u.isAttivo());
        utente.setId(u.getId());
        factory.getUtenteDAO().update(utente);
    }
}
