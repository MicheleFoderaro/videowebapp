package com.videowebapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "film", schema = "videowebapp")
public class Film implements Serializable{

    private int id;
    private String titolo;
    private int idGenere;
    private Integer anno;
    private String regista;
    private String cast;
    private String copertina;
    private Integer durata;
    private String descrizione;
    private Timestamp datacreazione;
    private Timestamp ultimamodifica;
    private Genere genereByIdGenere;

    public Film() {}

    public Film(String titolo, int idGenere, Integer anno, String regista, String cast, String copertina, Integer durata, String descrizione) {
        this.titolo = titolo;
        this.idGenere = idGenere;
        this.anno = anno;
        this.regista = regista;
        this.cast = cast;
        this.copertina = copertina;
        this.durata = durata;
        this.descrizione = descrizione;
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
    @Column(name = "titolo")
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Basic
    @Column(name = "id_genere")
    public int getIdGenere() {
        return idGenere;
    }

    public void setIdGenere(int idGenere) {
        this.idGenere = idGenere;
    }

    @Basic
    @Column(name = "anno")
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Basic
    @Column(name = "regista")
    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    @Basic
    @Column(name = "cast")
    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    @Basic
    @Column(name = "copertina")
    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }

    @Basic
    @Column(name = "durata")
    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
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

        Film that = (Film) o;

        if (id != that.id) return false;
        if (idGenere != that.idGenere) return false;
        if (titolo != null ? !titolo.equals(that.titolo) : that.titolo != null) return false;
        if (anno != null ? !anno.equals(that.anno) : that.anno != null) return false;
        if (regista != null ? !regista.equals(that.regista) : that.regista != null) return false;
        if (cast != null ? !cast.equals(that.cast) : that.cast != null) return false;
        if (copertina != null ? !copertina.equals(that.copertina) : that.copertina != null) return false;
        if (durata != null ? !durata.equals(that.durata) : that.durata != null) return false;
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
        result = 31 * result + (titolo != null ? titolo.hashCode() : 0);
        result = 31 * result + idGenere;
        result = 31 * result + (anno != null ? anno.hashCode() : 0);
        result = 31 * result + (regista != null ? regista.hashCode() : 0);
        result = 31 * result + (cast != null ? cast.hashCode() : 0);
        result = 31 * result + (copertina != null ? copertina.hashCode() : 0);
        result = 31 * result + (durata != null ? durata.hashCode() : 0);
        result = 31 * result + (descrizione != null ? descrizione.hashCode() : 0);
        result = 31 * result + (datacreazione != null ? datacreazione.hashCode() : 0);
        result = 31 * result + (ultimamodifica != null ? ultimamodifica.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn (name = "id_genere", referencedColumnName = "id")
    public Genere getGenereByIdGenere() {
        return genereByIdGenere;
    }

    public void setGenereByIdGenere(Genere genereByIdGenere) {
        this.genereByIdGenere = genereByIdGenere;
    }
}
