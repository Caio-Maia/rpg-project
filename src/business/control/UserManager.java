package business.control;

import infra.InfraException;
import infra.PersistenceManager;
import util.LoginInvalidException;
import util.PasswordInvalidException;
import util.UserValidador;
import java.util.Map;

import business.model.User;


public class UserManager {

	private Map<String, User> users;
	PersistenceManager persistence;
	private static volatile UserManager instance;
	
	private UserManager() {
		persistence = persistence.getInstance();
	}

	public UserManager getInstance() {
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
		
		users.put(args[0], new User(args[0],args[1]));
		persistence.saveData("user.bin", users);
		
	}
	
	public Map<String, User> getAllClients() throws InfraException {
		try {
			Map<String, User> mylist = persistence.loadData("user.bin");
			return mylist;

		} catch (NullPointerException ex){
			PersistenceManager.logger.severe(ex.getMessage());
	        throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
	           
		}
	}
	

}
