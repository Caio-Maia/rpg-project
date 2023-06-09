package main.java.view.commands.itensCommands;

import main.java.business.model.Item;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarItemCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;
    private Item item;

    public AtualizarItemCommand(MainScreenDesktop mainScreen, Integer id, Item item) {
        this.mainScreen = mainScreen;
        this.id = id;
        this.item = item;
    }

    @Override
    public void execute() {
        mainScreen.getItemManager().updateItem(id,item);
        JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!");
    }
}
