package main.java.view;

import main.java.business.control.UserManager;
import main.java.business.model.Usuario;
import main.java.infra.InfraException;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;

import javax.swing.JOptionPane;
import java.util.Iterator;


public class MainScreenDesktop {
	
	UserManager userManager;
	
	public static void main (String[] args) {
		showMenu();
	}
	
	public static void showMenu() {
		String option = JOptionPane.showInputDialog("Bem vindo ao sistema!\nEscolha a opcao desejada:\n1-Cadastrar Usuario\n2-Listar Usuarios\n3-Excluir Usuario\n4-Sair","Sua opcao");
		
		MainScreenDesktop main = new MainScreenDesktop();
		
		main.readUserInput(option);
	}
	
	public void readUserInput(String option) {
		userManager = userManager.getInstance();
		int choice = Integer.parseInt(option);
		boolean checkedLogin = false;
		boolean checkedPassword = false;
		switch (choice) {
		
		case 1:
			
			while (true) {
				String name = "";
				String pass = "";

				if (!checkedLogin) {
					name = JOptionPane.showInputDialog("Nome do usuario:");
					
				}
				if (!checkedPassword) {
					pass = JOptionPane.showInputDialog("Senha do usuario:");
					
				}

				try {
					String [] args = {name, pass};
					this.userManager.addUser(args);
					JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
					break;
				} catch (LoginInvalidException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() );
					checkedLogin = false;
					checkedPassword = true;
				} catch (PasswordInvalidException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() );
					checkedLogin = true;
					checkedPassword = false;
				} catch (InfraException e) {
					e.printStackTrace();
				}

			}
			showMenu();
			break;
		
		case 2:
			String usuarios = "";
			Iterator<Usuario> users;
			try {
				users = this.userManager.getAllClients().values().iterator();
				while (users.hasNext()) {
					Usuario usuario = users.next();
					usuarios = usuarios + "[ Login: " + usuario.getLogin() + " || Senha: " + usuario.getSenha() + " ]" + "\n";
				}
				JOptionPane.showMessageDialog(null, usuarios );
			} catch (InfraException e) {
				JOptionPane.showMessageDialog(null, e.getMessage() );
			}
			
			
			showMenu();
			break;
		case 3:
			break;
	
		}
	}
}