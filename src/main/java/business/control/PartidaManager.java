package main.java.business.control;

import main.java.business.model.Partida;
import main.java.business.model.Usuario;
import main.java.infra.DatabaseStrategy;
import main.java.infra.InfraException;
import main.java.infra.PartidaDatabaseStrategy;
import main.java.infra.PersistenceManager;

import java.sql.SQLException;
import java.util.Map;

public class PartidaManager {
    PersistenceManager persistence;
    private static volatile PartidaManager instance;

    private static DatabaseStrategy strategy;
    private PartidaManager() throws SQLException {
        strategy = new PartidaDatabaseStrategy();
        persistence = persistence.getInstance(strategy);
    }

    public static PartidaManager getInstance() throws SQLException {
        PartidaManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PersistenceManager.class) {
            if (instance == null) {
                instance = new PartidaManager();
            }
            return instance;
        }
    }

    public void addPartida(String nome, Integer usuario) throws InfraException, SQLException {
        persistence.saveData(strategy, new Partida(nome, usuario));
    }

    public Map<Integer, Partida> getAllPartidas() throws InfraException {
        try {
            Map<Integer, Partida> mylist = persistence.loadData(strategy);
            return mylist;

        } catch (NullPointerException ex){
            PersistenceManager.logger.severe(ex.getMessage());
            throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}