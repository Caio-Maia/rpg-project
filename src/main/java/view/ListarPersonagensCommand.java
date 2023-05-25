package main.java.view;

import main.java.business.model.Personagem;
import main.java.infra.InfraException;
import java.util.Map;

public class ListarPersonagensCommand implements Command{
    private MainScreenDesktop mainScreenDesktop;

    public ListarPersonagensCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        Map<Integer, Personagem> personagens = null;
        Boolean sucesso = true;
        String mensagemErro = "";
        try {
            personagens = this.mainScreenDesktop.personagemManager.getAllPersonagens();
        } catch (InfraException e) {
            sucesso = false;
            mensagemErro = e.getMessage();
        }
        mainScreenDesktop.listarPersonagens(personagens, sucesso, mensagemErro);
    }
}
