package main.java.view.commands.statusCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarStatusCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public AtualizarStatusCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        //mainScreen.getStatusManager().updateStatus();
        JOptionPane.showMessageDialog(null, "Status atualizado com sucesso!");
    }
}
