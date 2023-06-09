package main.java.view.commands.magiasCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarMagiaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarMagiaCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getMagiaManager().deleteMagia(id);
        JOptionPane.showMessageDialog(null, "Magia excluida com sucesso!");
    }
}
