package main.java.business.control;

import main.java.business.model.Usuario;
import main.java.infra.DatabaseStrategy;
import main.java.infra.PersistenceManager;
import main.java.infra.UsuarioDatabaseStrategy;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {

    private static volatile LoginManager instance;
    PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private Integer usuarioLogado;
    private boolean logged;
    private static Logger logger;

    private LoginManager() {
        strategy = new UsuarioDatabaseStrategy();
        persistence = PersistenceManager.getInstance(strategy);
    }

    public static LoginManager getInstance() {
        LoginManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (LoginManager.class) {
            if (instance == null) {
                instance = new LoginManager();
            }
            return instance;
        }
    }

    public boolean login(String login, String senha) {
        Map<Integer, Usuario> usuarios = persistence.loadData(strategy);
        for (Usuario user : usuarios.values()) {
            if (user.getLogin().equals(login)) {
                if(user.getSenha().equals(senha)) {
                    usuarioLogado = user.getId();
                    logged = true;
                    logger.log(Level.FINE, "Login successful. Bem Vindo, " + login + "!");
                    return true;
                }
            }
        }
        logger.log(Level.WARNING, "Credenciais Invalidas. Tente Novamente");
        return false;
    }

    public Integer getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean isLogged() {
        return logged;
    }

    public void logout() {
        usuarioLogado = null;
        logged = false;
        logger.log(Level.FINE, "Logged out com sucesso.");
    }
}
