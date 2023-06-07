package main.java.business.control;

import main.java.business.model.Item;
import main.java.infra.*;

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

    public void addItem(String nome, String descricao, Boolean temUsos, Integer quantidadeUsos, Integer quantidade) {
        persistence.saveData(strategy, new Item(nome, descricao, temUsos, quantidadeUsos, quantidade));
    }

    public Map<Integer, Item> getAllItens() throws InfraException {
        Map<Integer, Item> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public void updateItem(int id, String attributeName, Item item) {
        persistence.updateData(strategy, id, attributeName, item);
    }

    public void deleteItem(int id) {
        persistence.deleteData(strategy, id);
    }
}
