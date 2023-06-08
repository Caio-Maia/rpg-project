package main.java.view.commands.personagensCommands;

import main.java.business.model.Personagem;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarPersonagensCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;

    public ListarPersonagensCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Personagem> personagens = this.mainScreenDesktop.getPersonagemManager().getAllPersonagens();
            ListAdapter listAdapter = new ListAdapter(personagens);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaPersonagem());

            JOptionPane.showMessageDialog(null, barraRolagem, "Personagens", JOptionPane.INFORMATION_MESSAGE);

        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
