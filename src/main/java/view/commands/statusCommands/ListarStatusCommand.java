package main.java.view.commands.statusCommands;

import main.java.business.model.Personagem;
import main.java.business.model.Status;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarStatusCommand implements Command {
    private MainScreenDesktop mainScreen;

    public ListarStatusCommand(MainScreenDesktop mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Status> statuses = this.mainScreen.getStatusManager().getAllStatuses();
            ListAdapter listAdapter = new ListAdapter(statuses);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaStatus());

            JOptionPane.showMessageDialog(null, barraRolagem, "Statuses", JOptionPane.INFORMATION_MESSAGE);

        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
