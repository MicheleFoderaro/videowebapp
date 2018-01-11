package com.videowebapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "genere", schema = "videowebapp")
public class Genere implements Serializable {

    private int id;
    private String nome;
    private String descrizione;
    private Timestamp datacreazione;
    private Timestamp ultimamodifica;

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
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "descrizione")
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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

        Genere that = (Genere) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (descrizione != null ? !descrizione.equals(that.descrizione) : that.descrizione != null) return false;
        if (datacreazione != null ? !datacreazione.equals(that.datacreazione) : that.datacreazione != null)
            return false;
        if (ultimamodifica != null ? !ultimamodifica.equals(that.ultimamodifica) : that.ultimamodifica != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descrizione != null ? descrizione.hashCode() : 0);
        result = 31 * result + (datacreazione != null ? datacreazione.hashCode() : 0);
        result = 31 * result + (ultimamodifica != null ? ultimamodifica.hashCode() : 0);
        return result;
    }
}
