package main.java.business.control;

import main.java.business.model.Arma;
import main.java.business.model.enums.Atributo;
import main.java.infra.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ArmaManager {
    private static volatile ArmaManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(ArmaManager.class.getName());

    private ConnectionFactory connectionFactory;

    private ArmaManager() {
        strategy = new ArmaDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
        persistence.createTableIfNotExists(strategy);
    }

    public static ArmaManager getInstance() {
        ArmaManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (ArmaManager.class) {
            if (instance == null) {
                instance = new ArmaManager();
            }
            return instance;
        }
    }

    public void addArma(String nome, String requisito, Atributo atributo, String dano, String propriedades) throws InfraException {
        persistence.saveData(strategy, new Arma(nome, requisito, atributo, dano, propriedades));
    }

    public Map<Integer, Arma> getAllArmas() throws InfraException {
        Map<Integer, Arma> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public Map<Integer, Arma> getArmasByIds(List<Integer>ids) {
        Map<Integer, Arma> mylist = persistence.loadDataByListOfIds(ids);
        return  mylist;
    }

    public void updateArma(int id, String attributeName, Arma arma) {
        persistence.updateData(strategy, id,attributeName, arma);
    }

    public void deleteArma(int id) {
        persistence.deleteData(strategy, id);
    }
}
