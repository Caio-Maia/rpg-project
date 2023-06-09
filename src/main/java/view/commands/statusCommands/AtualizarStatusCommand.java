package main.java.view.commands.statusCommands;

import main.java.business.model.Status;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarStatusCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;
    private Status status;

    public AtualizarStatusCommand(MainScreenDesktop mainScreen, Integer id, Status status) {
        this.mainScreen = mainScreen;
        this.id = id;
        this.status = status;
    }

    @Override
    public void execute() {
        mainScreen.getStatusManager().updateStatus(id,status);
        JOptionPane.showMessageDialog(null, "Status atualizado com sucesso!");
    }
}
