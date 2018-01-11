package com.videowebapp.dao.jdbc;

import com.videowebapp.dao.GenereDAO;
import com.videowebapp.model.Genere;

import java.sql.*;
import java.util.HashMap;

public class JDBCDAOGenereImpl implements GenereDAO {

    private static JDBCDAOGenereImpl instance = new JDBCDAOGenereImpl();

    public synchronized static JDBCDAOGenereImpl getJDBCDAOGenereImpl() {
        return instance;
    }

    private JDBCDAOGenereImpl() {
    }


    @Override
    public HashMap<Integer, Genere> findAll() {
        String query = "SELECT * FROM genere";
        HashMap<Integer, Genere> mapGeneri = new HashMap<>();
        try (Connection conn = JDBCDAOFactory.getConnection();
             Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Genere g = new Genere();
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setDescrizione(rs.getString("descrizione"));
                mapGeneri.put(g.getId(), g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapGeneri;
    }

    @Override
    public void save(Genere g) {
        String s = "( '" + g.getNome() + "', '" + g.getDescrizione() + "');";
        String query = "INSERT INTO genere (nome, descrizione) VALUES ?";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try {
                stmt.setString(1, s);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Genere g) {
        String query = "UPDATE genere SET ? WHERE id = ? ";
        try(Connection conn = JDBCDAOFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            String s = "nome = '" + g.getNome() + "', descrizione = '" + g.getDescrizione();
            stmt.setString(1, s);
            stmt.setInt(2, g.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Genere g) {
        String query = "DELETE FROM genere WHERE id = ?";
        try (Connection conn = JDBCDAOFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, g.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Genere findById(int id) {
        String query = "SELECT * FROM genere WHERE id = ?";
        try {
            try(Connection conn = JDBCDAOFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                    Genere g = new Genere();
                    g.setId(rs.getInt("id"));
                    g.setNome(rs.getString("nome"));
                    g.setDescrizione(rs.getString("descrizione"));
                    return g;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
