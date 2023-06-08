package main.java.view.commands.magiasCommands;

import main.java.business.model.Item;
import main.java.business.model.Magia;
import main.java.infra.InfraException;
import main.java.view.ListAdapter;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.Map;

public class ListarMagiasCommand implements Command {
   private MainScreenDesktop mainScreen;

    public ListarMagiasCommand(MainScreenDesktop mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void execute() {
        try {
            Map<Integer, Magia> magias = this.mainScreen.getMagiaManager().getAllMagias();
            ListAdapter listAdapter = new ListAdapter(magias);
            JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaMagias());

            JOptionPane.showMessageDialog(null, barraRolagem, "Magias", JOptionPane.INFORMATION_MESSAGE);
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
