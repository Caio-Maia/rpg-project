package main.java.view;

import main.java.util.CredentialsInvalidException;

public class LoginCommand implements Command{
    private MainScreenDesktop mainScreenDesktop;

    private String login,senha;

    public LoginCommand(MainScreenDesktop mainScreenDesktop, String login, String senha) {
        this.mainScreenDesktop = mainScreenDesktop;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void execute() {
        Boolean sucesso = true;
        String mensagemErro = "";

        try {
            this.mainScreenDesktop.loginManager.login(login, senha);
        } catch (CredentialsInvalidException e) {
            sucesso = false;
            mensagemErro = e.getMessage();
        }

        this.mainScreenDesktop.realizarLogin(sucesso,mensagemErro);
    }
}
