package main.java.view.commands.magiasCommands;

import main.java.business.model.Magia;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarMagiaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;
    private Magia magia;

    public AtualizarMagiaCommand(MainScreenDesktop mainScreen, Integer id, Magia magia) {
        this.mainScreen = mainScreen;
        this.id = id;
        this.magia = magia;
    }

    @Override
    public void execute() {
        mainScreen.getMagiaManager().updateMagia(id,magia);
        JOptionPane.showMessageDialog(null, "Magia atualizada com sucesso!");
    }
}
