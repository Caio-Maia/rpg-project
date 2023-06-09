package main.java.view.commands.personagensCommands;

import main.java.infra.InfraException;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;
import java.util.ArrayList;

public class CriarPersonagemCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private String nome,ancestralidade,classe,dinheiro;
    private Integer criador, partida;
    private ArrayList<Integer> status,equipamentos,itens,talentos;

    public CriarPersonagemCommand(MainScreenDesktop mainScreenDesktop,Integer criador, String nome, Integer partida, String ancestralidade,String classe, String dinheiro, ArrayList<Integer> status,ArrayList<Integer> equipamentos,ArrayList<Integer> itens,ArrayList<Integer> talentos) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.criador = criador;
        this.nome = nome;
        this.partida = partida;
        this.ancestralidade = ancestralidade;
        this.classe = classe;
        this.dinheiro = dinheiro;
        this.status = status;
        this.equipamentos = equipamentos;
        this.itens = itens;
        this.talentos = talentos;
    }


    @Override
    public void execute() {
        try {
            mainScreenDesktop.getPersonagemManager().addPersonagem(criador,nome,partida,ancestralidade,classe,dinheiro,status,equipamentos,itens,talentos);
            JOptionPane.showMessageDialog(null, "Personagem criada com sucesso!");
        } catch (InfraException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
