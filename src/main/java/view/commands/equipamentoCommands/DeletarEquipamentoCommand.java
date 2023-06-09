package main.java.view.commands.equipamentoCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class DeletarEquipamentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarEquipamentoCommand(MainScreenDesktop mainScreen, Integer id) {
        this.mainScreen = mainScreen;
        this.id = id;
    }

    @Override
    public void execute() {
        mainScreen.getEquipamentoManager().deleteEquipamento(id);
        JOptionPane.showMessageDialog(null, "Equipamento excluido com sucesso!");
    }
}
