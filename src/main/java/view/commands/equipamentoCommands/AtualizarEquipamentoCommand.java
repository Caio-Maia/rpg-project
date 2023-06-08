package main.java.view.commands.equipamentoCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarEquipamentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public AtualizarEquipamentoCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        //mainScreen.getEquipamentoManager().updateEquipamento();
        JOptionPane.showMessageDialog(null, "Equipamento atualizado com sucesso!");
    }
}
