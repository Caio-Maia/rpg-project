package main.java.business.control;

import main.java.business.model.Partida;
import main.java.infra.*;

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
        persistence.createTableIfNotExists(strategy);
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

    public void addPartida(String nome, Integer usuario) throws InfraException {
        persistence.saveData(strategy, new Partida(nome, usuario));
    }

    public Map<Integer, Partida> getAllPartidas() throws InfraException {
        Map<Integer, Partida> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public void updatePartida(int id, String attributeName, Partida partida) {
        persistence.updateData(strategy, id,attributeName, partida);
    }

    public void deletePartida(int id) {
        persistence.deleteData(strategy, id);
    }
}