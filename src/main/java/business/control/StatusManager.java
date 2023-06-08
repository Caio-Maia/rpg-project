package main.java.business.control;

import main.java.business.model.Status;
import main.java.business.model.enums.Atributo;
import main.java.infra.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class StatusManager {

    private static volatile StatusManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(StatusManager.class.getName());

    private ConnectionFactory connectionFactory;

    private StatusManager() {
        strategy = new StatusDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
        persistence.createTableIfNotExists(strategy);
    }

    public static StatusManager getInstance() {
        StatusManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (StatusManager.class) {
            if (instance == null) {
                instance = new StatusManager();
            }
            return instance;
        }
    }

    public void addStatus(Atributo atributo, String valor, Boolean temModificador) throws InfraException {
        persistence.saveData(strategy, new Status(atributo, valor, temModificador));
    }

    public Map<Integer, Status> getAllStatuses() throws InfraException {
        Map<Integer, Status> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public Map<Integer, Status> getStatusesByIds(List<Integer> ids) {
        Map<Integer, Status> mylist = persistence.loadDataByListOfIds(ids);
        return  mylist;
    }

    public void updateStatus(int id, String attributeName, Status status) {
        persistence.updateData(strategy, id, attributeName, status);
    }

    public void deleteStatus(int id) {
        persistence.deleteData(strategy, id);
    }
}
