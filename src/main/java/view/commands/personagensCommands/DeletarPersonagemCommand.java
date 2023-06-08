package main.java.view.commands.personagensCommands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;

public class DeletarPersonagemCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;
    private Integer id;

    public DeletarPersonagemCommand(MainScreenDesktop mainScreenDesktop, Integer id) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.id = id;
    }

    @Override
    public void execute() {

    }
}
