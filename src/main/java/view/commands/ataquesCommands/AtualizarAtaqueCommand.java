package main.java.view.commands.ataquesCommands;

import main.java.business.model.Ataque;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarAtaqueCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;
    private Ataque ataque;

    public AtualizarAtaqueCommand(MainScreenDesktop mainScreen, Integer id, Ataque ataque) {
        this.mainScreen = mainScreen;
        this.id = id;
        this.ataque = ataque;
    }

    @Override
    public void execute() {
        mainScreen.getAtaqueManager().updateAtaque(id,ataque);
        JOptionPane.showMessageDialog(null, "Ataque atualizado com sucesso!");
    }
}
