package com.videowebapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
@Table(name = "utenti", schema = "videowebapp")
public class Utente implements Serializable {

    private int id;
    private String email;
    private String password;
    private int ruolo;
    private boolean attivo;
    private Timestamp datacreazione;
    private Timestamp ultimamodifica;

    public Utente(){}

    public Utente(String email, String password, int ruolo, boolean attivo) {
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
        this.attivo = attivo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ruolo")
    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

    @Basic
    @Column(name = "attivo")
    public boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    @Basic
    @Column(name = "datacreazione")
    public Timestamp getDatacreazione() {
        return datacreazione;
    }

    public void setDatacreazione(Timestamp datacreazione) {
        this.datacreazione = datacreazione;
    }

    @Basic
    @Column(name = "ultimamodifica")
    public Timestamp getUltimamodifica() {
        return ultimamodifica;
    }

    public void setUltimamodifica(Timestamp ultimamodifica) {
        this.ultimamodifica = ultimamodifica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utente that = (Utente) o;

        if (id != that.id) return false;
        if (ruolo != that.ruolo) return false;
        if (attivo != that.attivo) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (datacreazione != null ? !datacreazione.equals(that.datacreazione) : that.datacreazione != null)
            return false;
        if (ultimamodifica != null ? !ultimamodifica.equals(that.ultimamodifica) : that.ultimamodifica != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + ruolo;
        result = 31 * result + (datacreazione != null ? datacreazione.hashCode() : 0);
        result = 31 * result + (ultimamodifica != null ? ultimamodifica.hashCode() : 0);
        return result;
    }
}
