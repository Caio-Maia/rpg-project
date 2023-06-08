package main.java.business.control;

import main.java.business.model.Talento;
import main.java.infra.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TalentoManager {

    private static volatile TalentoManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(TalentoManager.class.getName());

    private ConnectionFactory connectionFactory;

    private TalentoManager() {
        strategy = new TalentoDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
        persistence.createTableIfNotExists(strategy);
    }

    public static TalentoManager getInstance() {
        TalentoManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (TalentoManager.class) {
            if (instance == null) {
                instance = new TalentoManager();
            }
            return instance;
        }
    }

    public void addTalento(String nome, String descricao, Boolean temConjuracoes, Integer qteConjuracoesMax, Integer qteConjuracoesRest) throws InfraException {
        persistence.saveData(strategy, new Talento(nome,descricao,temConjuracoes,qteConjuracoesMax,qteConjuracoesRest));
    }

    public Map<Integer, Talento> getAllTalentos() throws InfraException {
        Map<Integer, Talento> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public Map<Integer, Talento> getTalentosByIds(List<Integer> ids) {
        Map<Integer, Talento> mylist = persistence.loadDataByListOfIds(ids);
        return  mylist;
    }

    public void updateTalento(int id, Talento talento) {
        persistence.updateData(strategy, id, talento);
    }

    public void deleteTalento(int id) {
        persistence.deleteData(strategy, id);
    }
}
