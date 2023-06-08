package main.java.business.control;

import main.java.business.model.Personagem;
import main.java.infra.*;

import java.util.List;
import java.util.Map;

public class PersonagemManager {
    private PersistenceManager persistence;
    private static volatile PersonagemManager instance;

    private static DatabaseStrategy strategy;

    private static ConnectionFactory connectionFactory;

    private PersonagemManager() {
        strategy = new PersonagemDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = persistence.getInstance(connectionFactory,strategy);
    }

    public static PersonagemManager getInstance() {
        PersonagemManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PersonagemManager.class) {
            if (instance == null) {
                instance = new PersonagemManager();
            }
            return instance;
        }
    }

    public void addPersonagem(Integer usuario, String nome, Integer partida, String ancestralidade, String classe, String dinheiro, List<Integer> statusesId, List<Integer> equipamentosId, List<Integer> itensId, List<Integer> talentosId) {
        persistence.saveData(strategy,new Personagem(usuario, nome, partida, ancestralidade, classe, dinheiro, statusesId, equipamentosId, itensId, talentosId));
    }

    public Map<Integer, Personagem> getAllPersonagens() throws InfraException {
        Map<Integer, Personagem> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public Map<Integer, Personagem> getPersonagensByIds(List<Integer>ids) {
        Map<Integer, Personagem> mylist = persistence.loadDataByListOfIds(ids);
        return  mylist;
    }

    public void updatePersonagem(int id, String attributeName, Personagem personagem) {
        persistence.updateData(strategy, id, attributeName, personagem);
    }

    public void deletePersonagem(int id) {
        persistence.deleteData(strategy, id);
    }
}