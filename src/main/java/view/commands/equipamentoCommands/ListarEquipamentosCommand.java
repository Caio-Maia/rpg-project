package main.java.view.commands.equipamentoCommands;

import main.java.business.model.Ataque;
import main.java.business.model.Equipamento;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarEquipamentosCommand implements Command {
    private MainScreenDesktop mainScreen;

    public ListarEquipamentosCommand(MainScreenDesktop mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Equipamento> equipamentos = this.mainScreen.getEquipamentoManager().getAllEquipamentos();
            ListAdapter listAdapter = new ListAdapter(equipamentos);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaEquipamentos());

            JOptionPane.showMessageDialog(null, barraRolagem, "Equipamentos", JOptionPane.INFORMATION_MESSAGE);
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
