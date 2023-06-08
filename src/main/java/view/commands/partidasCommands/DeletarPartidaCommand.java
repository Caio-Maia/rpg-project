package main.java.view.commands.partidasCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class DeletarPartidaCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private Integer id;

    public DeletarPartidaCommand(MainScreenDesktop mainScreenDesktop, Integer id) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.id = id;
    }

    @Override
    public void execute() {
        /** Criar logica para exclusão da partida */
        System.out.println("Criar logica para excluir partida");
    }
}
