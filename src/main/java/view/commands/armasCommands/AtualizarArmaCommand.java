package main.java.view.commands.armasCommands;

import main.java.business.model.Arma;
import main.java.business.model.enums.Atributo;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class AtualizarArmaCommand implements Command {

    private MainScreenDesktop mainScreen;
    private Integer id;
    private  Arma arma;
    public AtualizarArmaCommand(MainScreenDesktop screen, Integer id, Arma arma) {
        this.mainScreen = screen;
        this.id = id;
        this.arma = arma;
    }

    @Override
    public void execute() {
        mainScreen.getArmaManager().updateArma(id,arma);
        JOptionPane.showMessageDialog(null, "Arma Atualizada com sucesso!");
    }
}
