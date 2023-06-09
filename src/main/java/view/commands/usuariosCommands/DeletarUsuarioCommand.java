package main.java.view.commands.usuariosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarUsuarioCommand implements Command {

    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarUsuarioCommand(MainScreenDesktop mainScreenDesktop, Integer id) {
        this.mainScreen = mainScreenDesktop;
        this.id = id;
    }

    @Override
    public void execute() {
        this.mainScreen.getUsuarioManager().deleteUsuario(id);
        JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso!");
    }
}
