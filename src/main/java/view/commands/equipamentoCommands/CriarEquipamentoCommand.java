package main.java.view.commands.equipamentoCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarEquipamentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String nome,defesa,requisito;

    public CriarEquipamentoCommand(MainScreenDesktop mainScreen, String nome, String defesa, String requisito) {
        this.mainScreen = mainScreen;
        this.nome = nome;
        this.defesa = defesa;
        this.requisito = requisito;
    }

    @Override
    public void execute() {
        mainScreen.getEquipamentoManager().addEquipamento(nome,defesa,requisito);
        JOptionPane.showMessageDialog(null, "Equipamento criado com sucesso!");
    }
}
