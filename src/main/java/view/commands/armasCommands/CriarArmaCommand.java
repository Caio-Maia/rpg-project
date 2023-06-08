package main.java.view.commands.armasCommands;

import main.java.business.model.enums.Atributo;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarArmaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String nome;
    private String requisito;
    private String atributo;
    private String dano;
    private String propriedade;
    public CriarArmaCommand(MainScreenDesktop screen, String nome, String requisito, String atributo, String dano, String propriedade) {
        this.mainScreen = screen;
        this.nome = nome;
        this.requisito = requisito;
        this.atributo = atributo;
        this.dano = dano;
        this.propriedade = propriedade;
    }

    @Override
    public void execute() {
        mainScreen.getArmaManager().addArma(nome,requisito, Atributo.valueOf(atributo),dano,propriedade);
        JOptionPane.showMessageDialog(null, "Arma criada com sucesso!");
    }
}
