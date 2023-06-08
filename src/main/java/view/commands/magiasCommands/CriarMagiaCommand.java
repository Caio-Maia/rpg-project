package main.java.view.commands.magiasCommands;

import main.java.business.model.enums.TipoAtaque;
import main.java.business.model.enums.TipoMagia;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarMagiaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String nome,tradicao,alvo,dano,critico,duracao,efeito,descricao,tipoMagia,tipoAtaque,contraAtaque;
    private Integer nivel,qteConjRest;

    public CriarMagiaCommand(MainScreenDesktop mainScreen, String nome, String tradicao, String alvo, String dano, String critico, String duracao, String efeito, String descricao, String tipoMagia, String tipoAtaque, String contraAtaque, Integer nivel, Integer qteConjRest) {
        this.mainScreen = mainScreen;
        this.nome = nome;
        this.tradicao = tradicao;
        this.alvo = alvo;
        this.dano = dano;
        this.critico = critico;
        this.duracao = duracao;
        this.efeito = efeito;
        this.descricao = descricao;
        this.tipoMagia = tipoMagia;
        this.tipoAtaque = tipoAtaque;
        this.contraAtaque = contraAtaque;
        this.nivel = nivel;
        this.qteConjRest = qteConjRest;
    }

    @Override
    public void execute() {
        mainScreen.getMagiaManager().addMagia(nome,tradicao, TipoMagia.valueOf(tipoMagia),nivel,alvo,dano,critico,duracao,efeito,descricao, TipoAtaque.valueOf(tipoAtaque),TipoAtaque.valueOf(contraAtaque),qteConjRest);
        JOptionPane.showMessageDialog(null, "Magia criada com sucesso!");
    }
}
