package business.control;

import business.model.Partida;
import business.model.User;
import infra.InfraException;
import infra.PersistenceManager;

import java.util.Map;

public class PartidaManager {
    private Map<String, Partida> partidas;
    PersistenceManager persistence;
    private static volatile PartidaManager instance;

    private PartidaManager() {
        persistence = persistence.getInstance();
    }

    public PartidaManager getInstance() {
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

    public void addPartida(String nome, User usuario) throws InfraException {
        partidas.put(nome, new Partida(nome, usuario));
        persistence.saveData("partida.bin", partidas);
    }

    public Map<String, Partida> getAllPartidas() throws InfraException {
        try {
            Map<String, Partida> mylist = persistence.loadData("partida.bin");
            return mylist;

        } catch (NullPointerException ex){
            PersistenceManager.logger.severe(ex.getMessage());
            throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");

        }
    }
}
