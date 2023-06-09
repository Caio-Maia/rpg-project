package main.java.view.commands.partidasCommands;

import main.java.infra.InfraException;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

import javax.swing.*;

public class CriarPartidaCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String nome;
    private Integer mestre;

    public CriarPartidaCommand(MainScreenDesktop mainScreenDesktop, String nome, Integer mestre){
        this.mainScreen = mainScreenDesktop;
        this.nome = nome;
        this.mestre = mestre;
    }

    public void execute(){
        try {
            mainScreen.getPartidaManager().addPartida(nome, mestre);
            JOptionPane.showMessageDialog(null, "Partida criada com sucesso!");
        } catch (InfraException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
