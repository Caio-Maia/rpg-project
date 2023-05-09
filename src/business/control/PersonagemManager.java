package business.control;

import business.model.Partida;
import business.model.Personagem;
import business.model.User;
import infra.InfraException;
import infra.PersistenceManager;

import java.util.Map;

public class PersonagemManager {
    private Map<String, Personagem> personagens;
    PersistenceManager persistence;
    private static volatile PersonagemManager instance;

    private PersonagemManager() {
        persistence = persistence.getInstance();
    }

    public PersonagemManager getInstance() {
        PersonagemManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PersistenceManager.class) {
            if (instance == null) {
                instance = new PersonagemManager();
            }
            return instance;
        }
    }

    public void addPersonagem(User usuario, String nome, Partida partida) throws InfraException {
        personagens.put(nome, new Personagem(usuario, nome, partida));
        persistence.saveData("personagem.bin", personagens);
    }

    public Map<String, Partida> getAllPersonagens() throws InfraException {
        try {
            Map<String, Partida> mylist = persistence.loadData("personagem.bin");
            return mylist;

        } catch (NullPointerException ex){
            PersistenceManager.logger.severe(ex.getMessage());
            throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");

        }
    }
}
