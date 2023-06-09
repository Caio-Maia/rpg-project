package main.java.view.commands;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.screenStates.MenuScreenState;

public class VoltarTelaCommand implements Command {
    private MainScreenDesktop mainScreenDesktop;

    public VoltarTelaCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreenDesktop = mainScreenDesktop;
    }
    @Override
    public void execute() {
        mainScreenDesktop.setScreenState(new MenuScreenState());
    }
}
