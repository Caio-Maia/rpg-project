package main.java.view.commands.ataquesCommands;

import main.java.business.model.Arma;
import main.java.business.model.Ataque;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarAtaquesCommand implements Command {
    private MainScreenDesktop mainScreen;

    public ListarAtaquesCommand(MainScreenDesktop mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Ataque> ataques = this.mainScreen.getAtaqueManager().getAllAtaques();
            ListAdapter listAdapter = new ListAdapter(ataques);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaAtaques());

            JOptionPane.showMessageDialog(null, barraRolagem, "Ataques", JOptionPane.INFORMATION_MESSAGE);
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

