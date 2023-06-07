package main.java.business.control;

import main.java.business.model.Equipamento;
import main.java.infra.*;

import java.util.Map;
import java.util.logging.Logger;

public class EquipamentoManager {

    private static volatile EquipamentoManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(EquipamentoManager.class.getName());

    private ConnectionFactory connectionFactory;

    private EquipamentoManager() {
        strategy = new EquipamentoDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
    }

    public static EquipamentoManager getInstance() {
        EquipamentoManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (EquipamentoManager.class) {
            if (instance == null) {
                instance = new EquipamentoManager();
            }
            return instance;
        }
    }

    public void addEquipamento(String nome, String defesa, String requisito) {
        persistence.saveData(strategy, new Equipamento(nome,defesa,requisito));
    }

    public Map<Integer, Equipamento> getAllEquipamentos() throws InfraException {
        Map<Integer, Equipamento> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public void updateEquipamento(int id, String attributeName, Equipamento equipamento) {
        persistence.updateData(strategy, id, attributeName, equipamento);
    }

    public void deleteEquipamento(int id) {
        persistence.deleteData(strategy, id);
    }
}
