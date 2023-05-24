package main.java.view;

import main.java.business.model.Partida;
import main.java.infra.InfraException;

import java.util.Iterator;

public class ListarPartidasCommand implements Command {
    private MainScreenDesktop mainScreen;
    public ListarPartidasCommand(MainScreenDesktop mainScreenDesktop){
        this.mainScreen = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Iterator<Partida> partidas = null;
        Boolean sucesso = true;
        String mensagemErro = "";
        try {
            partidas = this.mainScreen.partidaManager.getAllPartidas().values().iterator();
        } catch (InfraException e) {
            sucesso = false;
            mensagemErro = e.getMessage();
        }
        this.mainScreen.listarPartidas(partidas, sucesso, mensagemErro);
    }
}

