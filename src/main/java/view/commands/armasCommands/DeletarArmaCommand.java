package main.java.view.commands.armasCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarArmaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarArmaCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getArmaManager().deleteArma(id);
        JOptionPane.showMessageDialog(null, "Arma deletado com sucesso!");
    }
}
