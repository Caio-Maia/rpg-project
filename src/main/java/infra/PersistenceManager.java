package main.java.infra;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class PersistenceManager {
    private static final Logger logger = Logger.getLogger(PersistenceManager.class.getName());;
    private Connection conn;
    private DatabaseStrategy strategy;
    private static volatile PersistenceManager instance;

    private PersistenceManager(ConnectionFactory connectionFactory,DatabaseStrategy strategy) {
        try {
            conn = connectionFactory.getConnection();
            this.strategy = strategy;
            createTableIfNotExists();
            Runtime.getRuntime().addShutdownHook(new Thread(this::close));
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao criar conexão com o Banco de Dados", ex);
            logger.log(Level.SEVERE, "Detalhes: " + ex.getMessage());
        }
    }

    private void createTableIfNotExists() throws SQLException {
        try {
            strategy.createTableIfNotExists(conn);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao criar a tabela.", ex);
            logger.log(Level.SEVERE, "Detalhes da restrição violada: " + ex.getMessage());
        }
    }

    public static PersistenceManager getInstance(ConnectionFactory connectionFactory,DatabaseStrategy str) {
        PersistenceManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PersistenceManager.class) {
            if (instance == null) {
                instance = new PersistenceManager(connectionFactory,str);
            }
            return instance;
        }
    }

    public <T> void saveData(DatabaseStrategy strategy, T data) {
        String sql = strategy.getSaveQuery();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            strategy.setSaveParameters(stmt, data);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao tentar salvar dados", ex);
            logger.log(Level.SEVERE, "Detalhes:" + ex.getMessage());
        }
    }

    public <T> Map<Integer, T> loadData(DatabaseStrategy strategy) {
        String sql = strategy.getLoadQuery();
        Map<Integer, T> dataMap;
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            dataMap = strategy.loadData(rs);
        } catch (SQLException ex) {
            dataMap = new HashMap<>();
            logger.log(Level.SEVERE, "Erro ao tentar carregar dados do Banco", ex);
            logger.log(Level.SEVERE, "Detalhes: " + ex.getMessage());
        }
        return dataMap;
    }

    public void updateData(DatabaseStrategy strategy, int id, String attributeName, Object attributeValue) {
        String sql = strategy.getUpdateQuery(attributeName);
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, attributeValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao tentar atualizar os dados", ex);
            logger.log(Level.SEVERE, "Detalhes:" + ex.getMessage());
        }
    }

    public void deleteData(DatabaseStrategy strategy, int id) {
        String sql = strategy.getDeleteQuery();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro deletar informação", ex);
            logger.log(Level.SEVERE, "Detalhes: " + ex.getMessage());
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar a conexão.", ex);
                logger.log(Level.SEVERE, "Detalhes: " + ex.getMessage());
            }
        }
    }
}
