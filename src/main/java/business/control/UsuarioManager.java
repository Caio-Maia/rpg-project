package business.control;

import business.model.Usuario;
import infra.DatabaseStrategy;
import infra.InfraException;
import infra.PersistenceManager;
import infra.UsuarioDatabaseStrategy;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import util.UserValidador;

import java.sql.SQLException;
import java.util.Map;


public class UsuarioManager {
	PersistenceManager persistence;
	private static volatile UsuarioManager instance;
	private static DatabaseStrategy strategy;

	private UsuarioManager() throws SQLException {
		strategy = new UsuarioDatabaseStrategy();
		persistence = persistence.getInstance(strategy);
	}

	public static UsuarioManager getInstance() throws SQLException {
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
	
	public void addUser(String [] args) throws LoginInvalidException, PasswordInvalidException, InfraException, SQLException {
		
		UserValidador.validateName(args[0]);
		UserValidador.validatePassword(args[1]);

		persistence.saveData(strategy,new Usuario(args[0],args[1]));
		
	}
	
	public Map<Integer, Usuario> getAllClients() throws InfraException {
		try {
			Map<Integer, Usuario> mylist = persistence.loadData(strategy);
			return mylist;

		} catch (NullPointerException ex){
			PersistenceManager.logger.severe(ex.getMessage());
	        throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
	           
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
