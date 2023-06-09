package main.java.business.control;

import main.java.business.model.Ataque;
import main.java.business.model.enums.TipoAtaque;
import main.java.infra.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AtaqueManager {

    private static volatile AtaqueManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(AtaqueManager.class.getName());

    private ConnectionFactory connectionFactory;

    private AtaqueManager() {
        strategy = new AtaqueDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
        persistence.createTableIfNotExists(strategy);
    }

    public static AtaqueManager getInstance() {
        AtaqueManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (AtaqueManager.class) {
            if (instance == null) {
                instance = new AtaqueManager();
            }
            return instance;
        }
    }

    public void addAtaque(String nome, String distancia, TipoAtaque tipoAtaque, TipoAtaque contraAtaque, Integer dadiPerd, String dano, String critico, String descricao) throws InfraException {
        persistence.saveData(strategy, new Ataque(nome,distancia,tipoAtaque,contraAtaque,dadiPerd,dano,critico,descricao));
    }

    public Map<Integer, Ataque> getAllAtaques() throws InfraException {
        Map<Integer, Ataque> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public Map<Integer, Ataque> getAtaquesByIds(List<Integer> ids) {
        Map<Integer, Ataque> mylist = persistence.loadDataByListOfIds(ids);
        return  mylist;
    }

    public void updateAtaque(int id, Ataque ataque) {
        persistence.updateData(strategy, id, ataque);
    }

    public void deleteAtaque(int id) {
        persistence.deleteData(strategy, id);
    }
}
