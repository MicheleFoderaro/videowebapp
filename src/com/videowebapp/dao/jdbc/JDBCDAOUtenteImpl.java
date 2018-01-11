package com.videowebapp.dao.jdbc;

import com.videowebapp.dao.UtenteDAO;
import com.videowebapp.model.Film;
import com.videowebapp.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDAOUtenteImpl implements UtenteDAO {

    private static JDBCDAOUtenteImpl instance = new JDBCDAOUtenteImpl();

    public synchronized static JDBCDAOUtenteImpl getJDBCDAOUtenteImpl() {
        return instance;
    }

    private JDBCDAOUtenteImpl() {
    }

    @Override
    public void save(Utente u) {
        String query = "INSERT INTO utenti (email, password, ruolo) VALUES (?, ?, ?)";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try {
                stmt.setString(1, u.getEmail());
                stmt.setString(2, u.getPassword());
                stmt.setInt(3, u.getRuolo());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Utente u) {
        String query = "UPDATE utenti SET email = ?, password = ?, ruolo = ? WHERE id = ?";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getRuolo());
            stmt.setInt(4, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Utente u) {
        String query = "DELETE FROM utenti WHERE id = ?";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utente findById(int id) {
        String query = "SELECT * FROM utenti WHERE id = ?";
        Utente u = new Utente();
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRuolo(rs.getInt("ruolo"));
                u.setAttivo(rs.getBoolean("attivo"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return u;
    }

    @Override
    public List<Utente> findAll() {
        String query = "SELECT * FROM utenti";
        List<Utente> list = new ArrayList<>();
        try (Connection conn = JDBCDAOFactory.getConnection();
             Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRuolo(rs.getInt("ruolo"));
                u.setAttivo(rs.getBoolean("attivo"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
