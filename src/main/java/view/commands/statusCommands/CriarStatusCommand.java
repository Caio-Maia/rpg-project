package main.java.view.commands.statusCommands;

import main.java.business.model.enums.Atributo;
import main.java.infra.InfraException;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarStatusCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String atributo,valor;
    private Boolean temModificador;

    public CriarStatusCommand(MainScreenDesktop mainScreen, String atributo, String valor, Boolean temModificador) {
        this.mainScreen = mainScreen;
        this.atributo = atributo;
        this.valor = valor;
        this.temModificador = temModificador;
    }

    @Override
    public void execute() {
        try {
            mainScreen.getStatusManager().addStatus(Atributo.valueOf(atributo), valor, temModificador);
            JOptionPane.showMessageDialog(null, "Status criado com sucesso!");
        } catch (InfraException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
