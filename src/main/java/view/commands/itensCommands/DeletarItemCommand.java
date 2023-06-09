package main.java.view.commands.itensCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarItemCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarItemCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getItemManager().deleteItem(id);
        JOptionPane.showMessageDialog(null, "Item excluido com sucesso!");
    }
}
