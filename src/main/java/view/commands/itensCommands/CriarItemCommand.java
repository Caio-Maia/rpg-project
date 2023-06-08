package main.java.view.commands.itensCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarItemCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String nome,descricao;
    private Boolean temUsos;
    private Integer quatidadeUsos,quantidade;

    public CriarItemCommand(MainScreenDesktop mainScreen, String nome, String descricao, Boolean temUsos, Integer quatidadeUsos, Integer quantidade) {
        this.mainScreen = mainScreen;
        this.nome = nome;
        this.descricao = descricao;
        this.temUsos = temUsos;
        this.quatidadeUsos = quatidadeUsos;
        this.quantidade = quantidade;
    }

    @Override
    public void execute() {
        mainScreen.getItemManager().addItem(nome,descricao,temUsos,quatidadeUsos,quantidade);
        JOptionPane.showMessageDialog(null, "Item criado com sucesso!");
    }
}
