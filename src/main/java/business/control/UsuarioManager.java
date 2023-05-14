package main.java.business.control;

import main.java.business.model.Usuario;
import main.java.infra.DatabaseStrategy;
import main.java.infra.PersistenceManager;
import main.java.infra.UsuarioDatabaseStrategy;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;
import main.java.util.UserValidador;
import java.util.Map;


public class UsuarioManager {
	PersistenceManager persistence;
	private static volatile UsuarioManager instance;
	private static DatabaseStrategy strategy;

	private UsuarioManager() {
		strategy = new UsuarioDatabaseStrategy();
		persistence = persistence.getInstance(strategy);
	}

	public static UsuarioManager getInstance() {
		UsuarioManager result = instance;
		if(result != null) {
			return result;
		}
		synchronized (PersistenceManager.class) {
			if (instance == null) {
				instance = new UsuarioManager();
			}
			return instance;
		}
	}
	
	public void addUsuario(String [] args) throws LoginInvalidException, PasswordInvalidException {
		
		UserValidador.validateName(args[0]);
		UserValidador.validatePassword(args[1]);

		persistence.saveData(strategy, new Usuario(args[0],args[1]));
		
	}
	
	public Map<Integer, Usuario> getAllClients() {
		Map<Integer, Usuario> mylist = persistence.loadData(strategy);
		return mylist;
	}

	public void updateUsuario(int id, String [] args) throws LoginInvalidException, PasswordInvalidException {
		UserValidador.validateName(args[0]);
		UserValidador.validatePassword(args[1]);
		persistence.updateData(strategy, id, new Usuario(args[0],args[1]));
	}

	public void deleteUsuario(int id) {
		persistence.deleteData(strategy, id);
	}
}
