package main.java.view.commands.equipamentoCommands;

import main.java.business.model.Equipamento;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarEquipamentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private Integer id;
    private Equipamento equipamento;

    public AtualizarEquipamentoCommand(MainScreenDesktop mainScreen, Integer id, Equipamento equipamento) {
        this.mainScreen = mainScreen;
        this.id = id;
        this.equipamento = equipamento;
    }

    @Override
    public void execute() {
        mainScreen.getEquipamentoManager().updateEquipamento(id,equipamento);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado com sucesso!");
    }
}
