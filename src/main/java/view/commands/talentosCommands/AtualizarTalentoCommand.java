package main.java.view.commands.talentosCommands;

import main.java.business.model.Talento;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarTalentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;
    private Talento talento;

    public AtualizarTalentoCommand(MainScreenDesktop mainScreen, Integer id, Talento talento) {
        this.mainScreen = mainScreen;
        this.id = id;
        this.talento = talento;
    }

    @Override
    public void execute() {
        mainScreen.getTalentoManager().updateTalento(id,talento);
        JOptionPane.showMessageDialog(null, "Talento atualizado com sucesso!");
    }
}
