package main.java.view.commands.itensCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarItemCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public AtualizarItemCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        //mainScreen.getItemManager().updateItem();
        JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!");
    }
}
