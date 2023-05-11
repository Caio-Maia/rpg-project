/*package main.java.business.control;

import main.java.business.model.Partida;
import main.java.business.model.Personagem;
import main.java.business.model.Usuario;
import main.java.infra.InfraException;
import main.java.infra.PersistenceManager;


import java.sql.SQLException;
import java.util.Map;

public class PersonagemManager {
    PersistenceManager persistence;
    private static volatile PersonagemManager instance;

    private PersonagemManager() throws SQLException {
        persistence = persistence.getInstance();
    }

    public PersonagemManager getInstance() throws SQLException {
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

    public void addPersonagem(Usuario usuario, String nome, Partida partida) throws InfraException, SQLException {
        persistence.saveData(new Personagem(usuario, nome, partida));
    }

    public Map<Integer, Partida> getAllPersonagens() throws InfraException {

        try {
            Map<Integer, Partida> mylist = persistence.loadData();
            return mylist;

        } catch (NullPointerException ex){
            PersistenceManager.logger.severe(ex.getMessage());
            throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
*/