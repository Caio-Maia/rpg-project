package main.java.view.commands.usuariosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.screenStates.LoginScreenState;

import javax.swing.*;

public class LogoutCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;

    public LogoutCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        this.mainScreenDesktop.getLoginManager().logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso!");
        this.mainScreenDesktop.setScreenState(new LoginScreenState());
    }
}
