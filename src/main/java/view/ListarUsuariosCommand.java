package main.java.view;

import main.java.business.model.Usuario;


import java.util.Iterator;
import java.util.Map;

public class ListarUsuariosCommand implements Command{
    private MainScreenDesktop mainScreen;
    public ListarUsuariosCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreen = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Map<Integer, Usuario> users;
        users = this.mainScreen.usuarioManager.getAllClients();
        this.mainScreen.listarUsuarios(users);
    }
}
