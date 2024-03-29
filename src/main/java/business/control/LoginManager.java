package main.java.business.control;

import main.java.business.model.Usuario;
import main.java.infra.*;
import main.java.util.CredentialsInvalidException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {

    private static volatile LoginManager instance;
    private PersistenceManager persistence;
    private static DatabaseStrategy strategy;
    private Integer usuarioLogado;
    private boolean logged;
    private static final Logger logger = Logger.getLogger(LoginManager.class.getName());;
    private Map<Integer, Integer> acessos;
    private Map<Integer, Usuario> usuarios;
    private RelatorioAcessoUsuarios relatorio;

    private ConnectionFactory connectionFactory;

    private LoginManager() {
        strategy = new UsuarioDatabaseStrategy();
        connectionFactory = SQLiteConnectionFactory.getInstance();
        persistence = PersistenceManager.getInstance(connectionFactory,strategy);
        logged = false;
        acessos = new HashMap<>();
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

    public void login(String login, String senha) throws CredentialsInvalidException {
        usuarios = persistence.loadData(strategy);
        for (Usuario user : usuarios.values()) {
            if (user.getLogin().equals(login)) {
                if(user.getSenha().equals(senha)) {
                    usuarioLogado = user.getId();
                    logged = true;
                    Integer numeroAcessos = acessos.getOrDefault(usuarioLogado, 0);
                    acessos.put(usuarioLogado, numeroAcessos + 1);
                    logger.log(Level.FINE, "Login successful. Bem Vindo, " + login + "!");
                    return;
                }
            }
        }
        logger.log(Level.WARNING, "Credenciais Invalidas. Tente Novamente");
        throw new CredentialsInvalidException();
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

    public Map<Integer, Integer> getAcessos() {
        return acessos;
    }

    public void gerarRelatorioPDF() {
        relatorio = new RelatorioAcessoUsuariosPDF();
        relatorio.gerarRelatorio(usuarios, acessos);
    }

    public void gerarRelatorioHtml() {
        relatorio = new RelatorioAcessoUsuariosHTML();
        relatorio.gerarRelatorio(usuarios, acessos);
    }
}
