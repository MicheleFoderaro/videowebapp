package com.videowebapp.dao;


import com.videowebapp.dao.jdbc.JDBCDAOFactory;
import com.videowebapp.dao.jpa.JPADAOFactory;
import com.videowebapp.dao.memory.MemoryDAOFactory;

public abstract class FactoryDAO {
    public static final String MEMORY = "memory";
    public static final String JDBC = "jdbc";
    public static final String JPA = "jpa";

    public static FactoryDAO getFactoryDAO(String option) {
        switch (option) {
            case MEMORY:
                return MemoryDAOFactory.getInstance();
            case JDBC:
                return JDBCDAOFactory.getJDBCDAOFactory();
            case JPA:
                return JPADAOFactory.getJPADAOFactory();
            default:
                return null;
        }
    }

    public abstract FilmDAO getFilmDAO();
    public abstract GenereDAO getGenereDAO();
    public abstract UtenteDAO getUtenteDAO();

}
