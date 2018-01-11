package com.videowebapp.dao.dto;

import com.videowebapp.dao.FactoryDAO;
import com.videowebapp.facade.FacadeImpl;
import com.videowebapp.model.Film;
import com.videowebapp.model.Genere;
import com.videowebapp.model.Utente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DTOAssembler {

    private DTOAssembler() {}

    public static List<FilmDTO> linkFilmGenere(List<Film> films, HashMap<Integer, Genere> generi) {
        List<FilmDTO> filmsDTO = new ArrayList<>();
        for (Film f : films) {
            FilmDTO fDTO = new FilmDTO();
            fDTO.setId(f.getId());
            fDTO.setTitle(f.getTitolo());
            fDTO.setId_genere(f.getIdGenere());
            fDTO.setGeneri(generi);
            fDTO.setCast(f.getCast());
            fDTO.setPathCopertina(f.getCopertina());
            fDTO.setDescrizione(f.getDescrizione());
            fDTO.setDurata(f.getDurata());
            fDTO.setRegista(f.getRegista());
            fDTO.setYear(f.getAnno());
            filmsDTO.add(fDTO);
        }
        return filmsDTO;
    }

    public static List<UtenteDTO> linkUtente(List<Utente> utenti) {
        List<UtenteDTO> utentiDTO = new ArrayList<>();
        for (Utente u : utenti) {
            UtenteDTO utenteDTO = new UtenteDTO();
            utenteDTO.setId(u.getId());
            utenteDTO.setEmail(u.getEmail());
            utenteDTO.setPassword(u.getPassword());
            utenteDTO.setRuolo(u.getRuolo());
            utenteDTO.setAttivo(u.getAttivo());
            utentiDTO.add(utenteDTO);
        }
        return utentiDTO;
    }

    public static UtenteDTO linkOneUtente(Utente u) {
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setId(u.getId());
        utenteDTO.setEmail(u.getEmail());
        utenteDTO.setPassword(u.getPassword());
        utenteDTO.setRuolo(u.getRuolo());
        utenteDTO.setAttivo(u.getAttivo());
        return utenteDTO;
    }

    public static FilmDTO linkOneFilmToGenere(Film f, HashMap<Integer, Genere> generi) {
        FilmDTO fDTO = new FilmDTO();
        fDTO.setId(f.getId());
        fDTO.setTitle(f.getTitolo());
        fDTO.setId_genere(f.getIdGenere());
        fDTO.setGeneri(generi);
        fDTO.setCast(f.getCast());
        fDTO.setPathCopertina(f.getCopertina());
        fDTO.setDescrizione(f.getDescrizione());
        fDTO.setDurata(f.getDurata());
        fDTO.setRegista(f.getRegista());
        fDTO.setYear(f.getAnno());
        return fDTO;
    }
}
