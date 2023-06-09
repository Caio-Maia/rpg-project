package main.java.view.commands.usuariosCommands;

import main.java.business.model.Usuario;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;


import javax.swing.*;
import java.util.Map;

public class ListarUsuariosCommand implements Command {
    private MainScreenDesktop mainScreen;
    public ListarUsuariosCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreen = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Map<Integer, Usuario> users;
        users = this.mainScreen.getUsuarioManager().getAllClients();

        ListAdapter listAdapter = new ListAdapter(users);
        JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaUsuario());

        JOptionPane.showMessageDialog(null, barraRolagem, "Usuarios", JOptionPane.INFORMATION_MESSAGE);
    }
}
