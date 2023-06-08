package main.java.view.commands.talentosCommands;

import main.java.business.model.Personagem;
import main.java.business.model.Talento;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarTalentosCommand implements Command {
    private MainScreenDesktop mainScreen;

    public ListarTalentosCommand(MainScreenDesktop mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Talento> talentos = this.mainScreen.getTalentoManager().getAllTalentos();
            ListAdapter listAdapter = new ListAdapter(talentos);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaTalentos());

            JOptionPane.showMessageDialog(null, barraRolagem, "Talentos", JOptionPane.INFORMATION_MESSAGE);

        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
