package main.java.view;

import main.java.business.control.UsuarioManager;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;

public class CadastrarUsuarioCommand implements Command {
    private MainScreenDesktop mainScreen;
    private String[] args;

    public CadastrarUsuarioCommand(MainScreenDesktop mainScreenDesktop, String nome,String senha) {
        this.mainScreen = mainScreenDesktop;
        this.args = new String[]{nome,senha};
    }

    @Override
    public void execute(){
        Boolean cadastrado = true;
        Boolean checkedLogin = true,checkedPassword = true;
        String mensagemErro = "";
        try {
            this.mainScreen.usuarioManager.addUsuario(args);
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
        this.mainScreen.cadastrarUsuario(cadastrado,checkedLogin,checkedPassword,mensagemErro);

    }
}

