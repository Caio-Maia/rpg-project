package main.java.view.commands.partidasCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class AtualizarPartidaCommand implements Command {
   private MainScreenDesktop mainScreenDesktop;
   private String nome;
   private Integer id;

    public AtualizarPartidaCommand(MainScreenDesktop mainScreenDesktop,Integer id, String nome) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.id = id;
        this.nome = nome;
    }


    @Override
    public void execute() {
       /*** Criar logica para atualizar partida aqui */
       System.out.println("Adicionar execução de atualizar partida");
    }
}
