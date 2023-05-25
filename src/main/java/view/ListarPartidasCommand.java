package main.java.view;

import main.java.business.model.Partida;
import main.java.infra.InfraException;

import java.util.Iterator;
import java.util.Map;

public class ListarPartidasCommand implements Command {
    private MainScreenDesktop mainScreen;
    public ListarPartidasCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreen = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Map<Integer, Partida> partidas = null;
        String mensagemErro = "";
        boolean sucesso = true;
        try {
            partidas = this.mainScreen.partidaManager.getAllPartidas();
        } catch (InfraException e) {
            sucesso = false;
            mensagemErro = e.getMessage();
        }
        this.mainScreen.listarPartidas(partidas, sucesso, mensagemErro);
    }
}

