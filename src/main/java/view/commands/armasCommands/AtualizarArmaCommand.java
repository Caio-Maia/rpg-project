package main.java.view.commands.armasCommands;

import main.java.business.model.Arma;
import main.java.business.model.enums.Atributo;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarArmaCommand implements Command {

    private MainScreenDesktop mainScreen;
    private Integer id;
    private  String varName,valor;
    public AtualizarArmaCommand(MainScreenDesktop screen, Integer id, String varName, String valor) {
        this.mainScreen = screen;
        this.id = id;
        this.varName = varName;
        this.valor = valor;
    }

    @Override
    public void execute() {
        Arma arma = new Arma();
        switch (varName){
            case  "nome":
                arma.setNome(valor);
                break;
            case "requisito":
                arma.setRequisito(valor);
                break;
            case "atributo":
                arma.setAtributo(Atributo.valueOf(valor));
                break;
            case "dano":
                arma.setDano(valor);
                break;
            case "propriedade":
                arma.setPropriedades(valor);
                break;
        }
        mainScreen.getArmaManager().updateArma(id,varName,arma);
        JOptionPane.showMessageDialog(null, "Arma Atualizada com sucesso!");
    }
}
