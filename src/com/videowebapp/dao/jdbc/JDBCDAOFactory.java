package com.videowebapp.dao.jdbc;

import com.videowebapp.dao.FactoryDAO;
import com.videowebapp.dao.FilmDAO;
import com.videowebapp.dao.GenereDAO;
import com.videowebapp.dao.UtenteDAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDAOFactory extends FactoryDAO {

    private static JDBCDAOFactory instance = new JDBCDAOFactory();

    private JDBCDAOFactory() {}

    public static JDBCDAOFactory getJDBCDAOFactory() {
        return instance;
    }

    public static Connection getConnection() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/videowebapp");
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FilmDAO getFilmDAO() {
        return JDBCDAOFilmImpl.getJDBCDAOFilmImpl();
    }

    @Override
    public GenereDAO getGenereDAO() {
        return JDBCDAOGenereImpl.getJDBCDAOGenereImpl();
    }

    @Override
    public UtenteDAO getUtenteDAO() {return JDBCDAOUtenteImpl.getJDBCDAOUtenteImpl(); }
}


