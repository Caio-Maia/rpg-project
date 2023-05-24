package main.java.view;

import main.java.business.model.Usuario;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;

import java.util.Iterator;

public class ListarUsuariosCommand implements Command{
    private MainScreenDesktop mainScreen;
    public ListarUsuariosCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreen = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Iterator<Usuario> users;
        users = this.mainScreen.usuarioManager.getAllClients().values().iterator();
        this.mainScreen.listarUsuarios(users);
    }
}
