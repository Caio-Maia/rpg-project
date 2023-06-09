package main.java.view.commands.personagensCommands;

import main.java.business.model.Personagem;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class AtualizarPersonagemCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private Personagem personagem;
    private Integer id;

    public AtualizarPersonagemCommand(MainScreenDesktop mainScreenDesktop, Integer id, Personagem personagem) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.id = id;
        this.personagem = personagem;
    }

    @Override
    public void execute() {
        mainScreenDesktop.getPersonagemManager().updatePersonagem(id,personagem);
    }
}
