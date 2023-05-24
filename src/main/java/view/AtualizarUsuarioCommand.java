package main.java.view;

import main.java.business.control.UsuarioManager;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;

public class AtualizarUsuarioCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String[] args;

    private Integer id;
    public AtualizarUsuarioCommand(MainScreenDesktop mainScreenDesktop,Integer id, String nome, String senha) {
        this.mainScreen = mainScreenDesktop;
        this.args = new String[]{nome, senha};
        this.id = id;
    }

    @Override
    public void execute(){
        Boolean cadastrado = true;
        Boolean checkedLogin = true,checkedPassword = true;
        String mensagemErro = "";

        try {
            this.mainScreen.usuarioManager.updateUsuario(id, args);
        } catch (LoginInvalidException e) {
            mensagemErro = e.getMessage();
            cadastrado = false;
            checkedLogin = false;
            checkedPassword = true;
        } catch (PasswordInvalidException e) {
            mensagemErro = e.getMessage();
            cadastrado = false;
            checkedLogin = true;
            checkedPassword = false;
        }
        this.mainScreen.atualizarUsuario(id,cadastrado,checkedLogin,checkedPassword,mensagemErro);
    }
}

