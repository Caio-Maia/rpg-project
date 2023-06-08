package main.java.view.commands.ataquesCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarAtaqueCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public AtualizarAtaqueCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        //mainScreen.getAtaqueManager().updateAtaque();
        JOptionPane.showMessageDialog(null, "Ataque atualizado com sucesso!");
    }
}
