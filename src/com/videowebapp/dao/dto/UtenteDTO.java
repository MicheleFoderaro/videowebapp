package com.videowebapp.dao.dto;

import java.util.HashMap;

public class UtenteDTO {

    private int id;
    private String email;
    private String password;
    private int ruolo;
    private HashMap<Integer, String> ruoli;
    private boolean attivo;

    public UtenteDTO() {
        ruoli = new HashMap<>();
        ruoli.put(1, "Admin");
        ruoli.put(2, "User");
    }

    public UtenteDTO(String email, String password, int ruolo, boolean attivo) {
        this();
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
        this.attivo = attivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
}
