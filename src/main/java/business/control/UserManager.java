package main.java.business.control;


import main.java.business.model.Usuario;
import main.java.infra.InfraException;
import main.java.infra.PersistenceManager;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;
import main.java.util.UserValidador;
import java.util.Map;


public class UserManager {

	private Map<String, Usuario> users;
	PersistenceManager persistence;
	private static volatile UserManager instance;
	
	private UserManager() {
		persistence = persistence.getInstance();
	}

	public static UserManager getInstance() {
		UserManager result = instance;
		if(result != null) {
			return result;
		}
		synchronized (PersistenceManager.class) {
			if (instance == null) {
				instance = new UserManager();
			}
			return instance;
		}
	}
	
	public void addUser(String [] args) throws LoginInvalidException, PasswordInvalidException, InfraException {
		
		UserValidador.validateName(args[0]);
		UserValidador.validatePassword(args[1]);
		
		users.put(args[0], new Usuario(args[0],args[1]));
		persistence.saveData("user.bin", users);
		
	}
	
	public Map<String, Usuario> getAllClients() throws InfraException {
		try {
			Map<String, Usuario> mylist = persistence.loadData("user.bin");
			return mylist;

		} catch (NullPointerException ex){
			PersistenceManager.logger.severe(ex.getMessage());
	        throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
	           
		}
	}
	

}
