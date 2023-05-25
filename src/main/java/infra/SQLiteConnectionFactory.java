package main.java.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteConnectionFactory implements ConnectionFactory{

    private static String url = "jdbc:sqlite:database.db";
    private static final Logger logger = Logger.getLogger(SQLiteConnectionFactory.class.getName());;

    private static volatile SQLiteConnectionFactory instance;
    private SQLiteConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {

        SQLiteConnectionFactory result = instance;
        if (result != null) {
            return result;
        }
        synchronized (SQLiteConnectionFactory.class) {
            if (instance == null) {
                instance = new SQLiteConnectionFactory();
            }
            return instance;
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao criar conexão com o Banco de Dados", ex);
            logger.log(Level.SEVERE, "Detalhes: " + ex.getMessage());
        }
        return connection;
    }
}
