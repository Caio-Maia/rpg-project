package main.java.view.commands.relatoriosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class GerarRelatorioPdfCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;

    public GerarRelatorioPdfCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        this.mainScreenDesktop.getLoginManager().gerarRelatorioPDF();
        JOptionPane.showMessageDialog(null, "Relatorio PDF Gerado");
    }
}
