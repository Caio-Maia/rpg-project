package main.java.view.commands.armasCommands;

import main.java.business.model.Arma;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class AtualizarArmaCommand implements Command {

    private MainScreenDesktop mainScreen;
    private Integer id;
    private  String nome;
    private String requisito;
    private  String atributo;
    private String dano;
    private String propriedade;
    public AtualizarArmaCommand(MainScreenDesktop screen, Integer id, String nome, String requisito, String atributo, String dano, String propriedade) {
        this.mainScreen = screen;
        this.id = id;
        this.nome = nome;
        this.requisito = requisito;
        this.atributo = atributo;
        this.dano = dano;
        this.propriedade = propriedade;
    }

    @Override
    public void execute() {
        //Arma arma = new Arma()
        //mainScreen.getArmaManager().updateArma(id);
    }
}
