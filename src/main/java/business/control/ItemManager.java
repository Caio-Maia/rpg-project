package main.java.business.control;

import main.java.business.model.Item;
import main.java.infra.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ItemManager {

    private static volatile ItemManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(ItemManager.class.getName());

    private ConnectionFactory connectionFactory;

    private ItemManager() {
        strategy = new ItemDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
        persistence.createTableIfNotExists(strategy);
    }

    public static ItemManager getInstance() {
        ItemManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (ItemManager.class) {
            if (instance == null) {
                instance = new ItemManager();
            }
            return instance;
        }
    }

    public void addItem(String nome, String descricao, Boolean temUsos, Integer quantidadeUsos, Integer quantidade) throws InfraException {
        persistence.saveData(strategy, new Item(nome, descricao, temUsos, quantidadeUsos, quantidade));
    }

    public Map<Integer, Item> getAllItens() throws InfraException {
        Map<Integer, Item> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public Map<Integer, Item> getItensByIds(List<Integer> ids) {
        Map<Integer, Item> mylist = persistence.loadDataByListOfIds(ids);
        return  mylist;
    }

    public void updateItem(int id, Item item) {
        persistence.updateData(strategy, id, item);
    }

    public void deleteItem(int id) {
        persistence.deleteData(strategy, id);
    }
}
