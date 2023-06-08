package main.java.view.commands.talentosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarTalentoCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String nome,descricao;
    private Boolean temConjuracoes;
    private Integer qteConjMax,qteConjRest;

    public CriarTalentoCommand(MainScreenDesktop mainScreen, String nome, String descricao, Boolean temConjuracoes, Integer qteConjMax, Integer qteConjRest) {
        this.mainScreen = mainScreen;
        this.nome = nome;
        this.descricao = descricao;
        this.temConjuracoes = temConjuracoes;
        this.qteConjMax = qteConjMax;
        this.qteConjRest = qteConjRest;
    }

    @Override
    public void execute() {
        mainScreen.getTalentoManager().addTalento(nome,descricao,temConjuracoes,qteConjMax,qteConjRest);
        JOptionPane.showMessageDialog(null, "Talento criado com sucesso!");
    }
}
