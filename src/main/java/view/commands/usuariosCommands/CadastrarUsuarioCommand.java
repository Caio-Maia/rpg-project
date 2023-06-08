package main.java.view.commands.usuariosCommands;

import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CadastrarUsuarioCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String[] args;

    public CadastrarUsuarioCommand(MainScreenDesktop mainScreenDesktop, String nome,String senha) {
        this.mainScreen = mainScreenDesktop;
        this.args = new String[]{nome,senha};
    }

    @Override
    public void execute(){
        try {
            mainScreen.getUsuarioManager().addUsuario(args);
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
        } catch (LoginInvalidException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        } catch (PasswordInvalidException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}

