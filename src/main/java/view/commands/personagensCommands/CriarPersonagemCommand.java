package main.java.view.commands.personagensCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarPersonagemCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private String nome;
    private Integer criador, partida;

    public CriarPersonagemCommand(MainScreenDesktop mainScreenDesktop, String nome, Integer criador, Integer partida) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.nome = nome;
        this.criador = criador;
        this.partida = partida;
    }


    @Override
    public void execute() {
        //mainScreenDesktop.getPersonagemManager().addPersonagem(criador,nome,partida);
        JOptionPane.showMessageDialog(null, "Personagem criada com sucesso!");
    }
}
