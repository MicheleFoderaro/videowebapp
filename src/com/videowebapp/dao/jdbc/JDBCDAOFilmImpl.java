package com.videowebapp.dao.jdbc;

import com.sun.org.apache.regexp.internal.RE;
import com.videowebapp.dao.FilmDAO;
import com.videowebapp.model.Database;
import com.videowebapp.model.Film;
import com.videowebapp.model.Genere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDAOFilmImpl implements FilmDAO {

    private static JDBCDAOFilmImpl instance = new JDBCDAOFilmImpl();

    public static JDBCDAOFilmImpl getJDBCDAOFilmImpl() {
        return instance;
    }

    private JDBCDAOFilmImpl() {
    }

    @Override
    public List<Film> findAll() {

        String query = "SELECT * FROM film";
        List<Film> list = new ArrayList<>();
        try (Connection conn = JDBCDAOFactory.getConnection();
             Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Film f = new Film();
                f.setId(rs.getInt("id"));
                f.setTitolo(rs.getString("titolo"));
                f.setIdGenere(rs.getInt("id_genere"));
                f.setAnno(rs.getInt("anno"));
                f.setRegista(rs.getString("regista"));
                f.setCast(rs.getString("cast"));
                f.setCopertina(rs.getString("copertina"));
                f.setDurata(rs.getInt("durata"));
                f.setDescrizione(rs.getString("descrizione"));
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Film f) {
        String query = "INSERT INTO film (titolo, id_genere, anno, regista, cast, copertina, durata, descrizione) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try {
                stmt.setString(1, f.getTitolo());
                stmt.setInt(2, f.getIdGenere());
                stmt.setInt(3, f.getAnno());
                stmt.setString(4, f.getRegista());
                stmt.setString(5, f.getCast());
                stmt.setString(6, f.getCopertina());
                stmt.setInt(7, f.getDurata());
                stmt.setString(8, f.getDescrizione());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Film f) {
        String query = "UPDATE film SET titolo = ?, id_genere = ?, anno = ?, regista = ?, cast = ?, copertina = ?, descrizione = ? WHERE id = ?";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, f.getTitolo());
            stmt.setInt(2, f.getIdGenere());
            stmt.setInt(3, f.getAnno());
            stmt.setString(4, f.getRegista());
            stmt.setString(5, f.getCast());
            stmt.setString(6, f.getCopertina());
            stmt.setString(7, f.getDescrizione());
            stmt.setInt(8, f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Film f) {
        String query = "DELETE FROM film WHERE id = ?";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film findById(int id) {
        String query = "SELECT * FROM film WHERE id = ?";
        Film f = new Film();
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setTitolo(rs.getString("titolo"));
                f.setIdGenere(rs.getInt("id_genere"));
                f.setAnno(rs.getInt("anno"));
                f.setRegista(rs.getString("regista"));
                f.setCast(rs.getString("cast"));
                f.setCopertina(rs.getString("copertina"));
                f.setDurata(rs.getInt("durata"));
                f.setDescrizione(rs.getString("descrizione"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return f;
    }
}
