package main.java.view.commands.statusCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarStatusCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarStatusCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getStatusManager().deleteStatus(id);
        JOptionPane.showMessageDialog(null, "Status excluido com sucesso!");
    }
}
