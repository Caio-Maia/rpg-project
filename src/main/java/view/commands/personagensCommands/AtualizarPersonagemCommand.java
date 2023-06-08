package main.java.view.commands.personagensCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class AtualizarPersonagemCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private String nome;
    private Integer partida;

    public AtualizarPersonagemCommand(MainScreenDesktop mainScreenDesktop, String nome, Integer partida) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.nome = nome;
        this.partida = partida;
    }

    @Override
    public void execute() {

    }
}
