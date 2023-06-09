package main.java.view.commands.partidasCommands;

import main.java.business.model.Partida;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class AtualizarPartidaCommand implements Command {
   private MainScreenDesktop mainScreenDesktop;
   private Partida partida;
   private Integer id;

    public AtualizarPartidaCommand(MainScreenDesktop mainScreenDesktop,Integer id, Partida partida) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.id = id;
        this.partida = partida;
    }


    @Override
    public void execute() {
       mainScreenDesktop.getPartidaManager().updatePartida(id,partida);
       System.out.println("Adicionar execução de atualizar partida");
    }
}
