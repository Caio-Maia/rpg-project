package main.java.view.commands.relatoriosCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class GerarRelatorioHtmlCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;

    public GerarRelatorioHtmlCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        this.mainScreenDesktop.getLoginManager().gerarRelatorioHtml();
        JOptionPane.showMessageDialog(null, "Relatorio HTML Gerado");
    }
}
