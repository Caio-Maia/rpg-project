package main.java.view.commands.talentosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarTalentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarTalentoCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getTalentoManager().deleteTalento(id);
        JOptionPane.showMessageDialog(null, "Talento excluido com sucesso!");
    }
}
