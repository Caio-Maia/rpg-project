package main.java.business.control;

import main.java.business.model.Partida;
import main.java.business.model.Usuario;
import main.java.infra.*;

import java.sql.SQLException;
import java.util.Map;

public class PartidaManager {
    private PersistenceManager persistence;
    private static volatile PartidaManager instance;
    private static ConnectionFactory connectionFactory;
    private static DatabaseStrategy strategy;
    private PartidaManager() {
        strategy = new PartidaDatabaseStrategy();
        connectionFactory =SQLiteConnectionFactory.getInstance();
        persistence = persistence.getInstance(connectionFactory,strategy);
    }

    public static PartidaManager getInstance() {
        PartidaManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PartidaManager.class) {
            if (instance == null) {
                instance = new PartidaManager();
            }
            return instance;
        }
    }

    public void addPartida(String nome, Integer usuario) {
        persistence.saveData(strategy, new Partida(nome, usuario));
    }

    public Map<Integer, Partida> getAllPartidas() throws InfraException {
        Map<Integer, Partida> mylist = persistence.loadData(strategy);
        return mylist;
    }
}