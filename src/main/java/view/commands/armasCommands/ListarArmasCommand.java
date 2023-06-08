package main.java.view.commands.armasCommands;

import main.java.business.model.Arma;
import main.java.business.model.Partida;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarArmasCommand implements Command {

    private MainScreenDesktop mainScreen;
    public ListarArmasCommand(MainScreenDesktop screen) {
        this.mainScreen = screen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Arma> armas = this.mainScreen.getArmaManager().getAllArmas();
            ListAdapter listAdapter = new ListAdapter(armas);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaArmas());

            JOptionPane.showMessageDialog(null, barraRolagem, "Armas", JOptionPane.INFORMATION_MESSAGE);
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
