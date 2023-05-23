package main.java.business.control;

import main.java.business.model.Partida;
import main.java.business.model.Personagem;
import main.java.business.model.Usuario;
import main.java.infra.DatabaseStrategy;
import main.java.infra.InfraException;
import main.java.infra.PersistenceManager;
import main.java.infra.PersonagemDatabaseStrategy;

import java.sql.SQLException;
import java.util.Map;

public class PersonagemManager {
    PersistenceManager persistence;
    private static volatile PersonagemManager instance;

    private static DatabaseStrategy strategy;

    private PersonagemManager() {
        strategy = new PersonagemDatabaseStrategy();
        persistence = persistence.getInstance(strategy);
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

    public void addPersonagem(Integer usuario, String nome, Integer partida) {
        persistence.saveData(strategy,new Personagem(usuario, nome, partida));
    }

    public Map<Integer, Personagem> getAllPersonagens() throws InfraException {
        Map<Integer, Personagem> mylist = persistence.loadData(strategy);
        return mylist;
    }
}