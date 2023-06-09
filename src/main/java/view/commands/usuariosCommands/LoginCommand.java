package main.java.view.commands.usuariosCommands;

import main.java.util.CredentialsInvalidException;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.screenStates.MenuScreenState;

import javax.swing.*;

public class LoginCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private String login,senha;

    public LoginCommand(MainScreenDesktop mainScreenDesktop, String login, String senha) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void execute() {
        try {
            this.mainScreenDesktop.getLoginManager().login(login, senha);
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            mainScreenDesktop.setScreenState(new MenuScreenState());

        } catch (CredentialsInvalidException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
