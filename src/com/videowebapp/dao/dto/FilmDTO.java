package com.videowebapp.dao.dto;

import com.videowebapp.model.Film;
import com.videowebapp.model.Genere;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FilmDTO implements Serializable {

    private int id;
    private String title;
    private int id_genere;
    private Map<Integer, Genere> generi;
    private int year;
    private String cast;
    private String pathCopertina;
    private String regista;
    private int durata;
    private String descrizione;

    public Map<Integer, Genere> getGeneri() {
        return generi;
    }

    public FilmDTO() {}

    public FilmDTO(Map<Integer, Genere> generi) {
        this.generi = generi;
    }

    public FilmDTO(String title, int id_genere, Map<Integer, Genere> generi, int year, String cast, String pathCopertina, String regista, int durata, String descrizione) {
        this.title = title;
        this.id_genere = id_genere;
        this.generi = generi;
        this.year = year;
        this.cast = cast;
        this.pathCopertina = pathCopertina;
        this.regista = regista;
        this.durata = durata;
        this.descrizione = descrizione;
    }

    public int getId_genere() {
        return id_genere;
    }

    public void setId_genere(int id_genere) {
        this.id_genere = id_genere;
    }

    public void setGeneri(Map<Integer, Genere> generi) {

        this.generi = generi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPathCopertina() {
        return pathCopertina;
    }

    public void setPathCopertina(String pathCopertina) {
        this.pathCopertina = pathCopertina;
    }

}
