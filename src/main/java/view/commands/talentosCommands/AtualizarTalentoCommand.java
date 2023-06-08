package main.java.view.commands.talentosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarTalentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public AtualizarTalentoCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        //mainScreen.getTalentoManager().updateTalento();
        JOptionPane.showMessageDialog(null, "Talento atualizado com sucesso!");
    }
}
