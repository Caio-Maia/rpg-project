package main.java.view.commands.ataquesCommands;

import main.java.business.model.enums.TipoAtaque;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarAtaqueCommand implements Command {
   private MainScreenDesktop mainScreen;
    private String nome;
    private String distancia;
    private String tipoAtaque;
    private String contraAtaque;
    private Integer dadiPerd;
    private String dano;
    private String critico;
    private String descricao;


    public CriarAtaqueCommand(MainScreenDesktop mainScreen, String nome, String distancia, String tipoAtaque, String contraAtaque, Integer dadiPerd, String dano, String critico, String descricao) {
        this.mainScreen = mainScreen;
        this.nome = nome;
        this.distancia = distancia;
        this.tipoAtaque = tipoAtaque;
        this.contraAtaque = contraAtaque;
        this.dadiPerd = dadiPerd;
        this.dano = dano;
        this.critico = critico;
        this.descricao = descricao;
    }

    @Override
    public void execute() {
        mainScreen.getAtaqueManager().addAtaque(nome,distancia,TipoAtaque.valueOf(tipoAtaque),TipoAtaque.valueOf(contraAtaque),dadiPerd,dano,critico,descricao);
        JOptionPane.showMessageDialog(null, "Ataque criado com sucesso!");
    }
}
