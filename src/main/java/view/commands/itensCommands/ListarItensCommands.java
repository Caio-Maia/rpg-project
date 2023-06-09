package main.java.view.commands.itensCommands;

import main.java.business.model.Equipamento;
import main.java.business.model.Item;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarItensCommands implements Command {
    private MainScreenDesktop mainScreen;

    public ListarItensCommands(MainScreenDesktop mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Item> itens = this.mainScreen.getItemManager().getAllItens();
            ListAdapter listAdapter = new ListAdapter(itens);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaItens());

            JOptionPane.showMessageDialog(null, barraRolagem, "Itens", JOptionPane.INFORMATION_MESSAGE);
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
