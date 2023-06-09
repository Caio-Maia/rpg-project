package main.java.view.commands.usuariosCommands;

import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarUsuarioCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String[] args;

    private Integer id;
    public AtualizarUsuarioCommand(MainScreenDesktop mainScreenDesktop,Integer id, String nome, String senha) {
        this.mainScreen = mainScreenDesktop;
        this.args = new String[]{nome, senha};
        this.id = id;
    }

    @Override
    public void execute(){
        try {
            this.mainScreen.getUsuarioManager().updateUsuario(id, args);
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } catch (LoginInvalidException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (PasswordInvalidException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

