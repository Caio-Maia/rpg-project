package main.java.view.commands.ataquesCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarAtaqueCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarAtaqueCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getAtaqueManager().deleteAtaque(id);
        JOptionPane.showMessageDialog(null, "Ataque excluido com sucesso!");
    }
}
