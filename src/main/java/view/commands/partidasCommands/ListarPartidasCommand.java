package main.java.view.commands.partidasCommands;

import main.java.business.model.Partida;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarPartidasCommand implements Command {
    private MainScreenDesktop mainScreen;
    public ListarPartidasCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreen = mainScreenDesktop;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Partida> partidas = this.mainScreen.getPartidaManager().getAllPartidas();
            ListAdapter listAdapter = new ListAdapter(partidas);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaPartida());

            JOptionPane.showMessageDialog(null, barraRolagem, "Partidas", JOptionPane.INFORMATION_MESSAGE);
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

