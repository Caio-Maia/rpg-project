package main.java.business.control;

import main.java.business.model.Magia;
import main.java.business.model.enums.TipoAtaque;
import main.java.business.model.enums.TipoMagia;
import main.java.infra.*;

import java.util.Map;
import java.util.logging.Logger;

public class MagiaManager {

    private static volatile MagiaManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private static final Logger logger = Logger.getLogger(MagiaManager.class.getName());

    private ConnectionFactory connectionFactory;

    private MagiaManager() {
        strategy = new MagiaDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
    }

    public static MagiaManager getInstance() {
        MagiaManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (MagiaManager.class) {
            if (instance == null) {
                instance = new MagiaManager();
            }
            return instance;
        }
    }

    public void addMagia(String nome, String tradicao, TipoMagia tipoMagia, Integer nivel, String alvo, String dano, String critico, String duracao, String efeito, String descricao, TipoAtaque tipoAtaque, TipoAtaque contraAtaque, Integer qteConjuracoesRest) {
        persistence.saveData(strategy, new Magia(nome, tradicao, tipoMagia, nivel, alvo, dano, critico, duracao, efeito, descricao, tipoAtaque, contraAtaque, qteConjuracoesRest));
    }

    public Map<Integer, Magia> getAllMagias() throws InfraException {
        Map<Integer, Magia> mylist = persistence.loadData(strategy);
        return mylist;
    }

    public void updateMagia(int id, String attributeName, Magia magia) {
        persistence.updateData(strategy, id, attributeName, magia);
    }

    public void deleteMagia(int id) {
        persistence.deleteData(strategy, id);
    }
}
