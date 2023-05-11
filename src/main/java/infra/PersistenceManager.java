package infra;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class PersistenceManager {
    private Connection conn;
    private DatabaseStrategy strategy;
    private static volatile PersistenceManager instance;
    public static Logger logger = Logger.getLogger(PersistenceManager.class.getName());

    private PersistenceManager(DatabaseStrategy strategy) throws SQLException {
        String url = "jdbc:sqlite:database.db";
        conn = DriverManager.getConnection(url);
        this.strategy = strategy;
        createTableIfNotExists();
    }

    private void createTableIfNotExists() throws SQLException {
        strategy.createTableIfNotExists(conn);
    }

    public static PersistenceManager getInstance(DatabaseStrategy str) throws SQLException {
        PersistenceManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PersistenceManager.class) {
            if (instance == null) {
                instance = new PersistenceManager(str);
            }
            return instance;
        }
    }

    public <T> void saveData(DatabaseStrategy strategy, T data) throws SQLException {
        String sql = strategy.getSaveQuery();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            strategy.setSaveParameters(stmt, data);
            stmt.executeUpdate();
        }
    }

    public <T> Map<Integer, T> loadData(DatabaseStrategy strategy) throws SQLException {
        String sql = strategy.getLoadQuery();
        Map<Integer, T> dataMap;
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            dataMap = strategy.loadData(rs);
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro ao desserializar objeto", ex);
        }
        return dataMap;
    }
}
