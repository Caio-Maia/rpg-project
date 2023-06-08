package main.java.view.commands.magiasCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarMagiaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public AtualizarMagiaCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        //mainScreen.getMagiaManager().updateMagia();
        JOptionPane.showMessageDialog(null, "Magia atualizada com sucesso!");
    }
}
