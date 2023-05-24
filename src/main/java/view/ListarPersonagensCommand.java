package main.java.view;

import main.java.business.model.Personagem;
import main.java.infra.InfraException;

import java.util.Iterator;

public class ListarPersonagensCommand implements Command{
    private MainScreenDesktop mainScreenDesktop;

    public ListarPersonagensCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Iterator<Personagem> personagens = null;
        Boolean sucesso = true;
        String mensagemErro = "";
        try {
            personagens = this.mainScreenDesktop.personagemManager.getAllPersonagens().values().iterator();
        } catch (InfraException e) {
            sucesso = false;
            mensagemErro = e.getMessage();
        }
        mainScreenDesktop.listarPersonagens(personagens, sucesso, mensagemErro);
    }
}
