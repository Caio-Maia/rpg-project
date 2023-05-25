package main.java.view;

import main.java.business.control.LoginManager;
import main.java.business.control.PartidaManager;
import main.java.business.control.PersonagemManager;
import main.java.business.control.UsuarioManager;
import main.java.business.model.Partida;
import main.java.business.model.Personagem;
import main.java.business.model.Usuario;

import javax.swing.*;
import java.util.Iterator;
import java.util.Map;


public class MainScreenDesktop {

    LoginManager loginManager;
    UsuarioManager usuarioManager;
    PersonagemManager personagemManager;
    PartidaManager partidaManager;

    private Command comandoAtual;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        String option = JOptionPane.showInputDialog("Bem vindo ao sistema!" +
                "\nEscolha a opcao desejada:" +
                "\n1-Cadastrar Usuario" +
                "\n2-Listar Usuarios" +
                "\n3-Excluir Usuario" +
                "\n4-Atualizar Usuario" +
                "\n5-Lista partidas" +
                "\n6-Lista Personagens" +
                "\n7-Realizar Login" +
                "\n8-Gerar Relatorio HTML" +
                "\n9-Gerar Relatorio PDF" +
                "\n10-Realizar Logout", "Sua opcao");

        MainScreenDesktop main = new MainScreenDesktop();
        if(option != null) {
            try {
                main.readUserInput(option);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida");
                showMenu();
            }
        }
    }

    public void readUserInput(String option) {
        loginManager = LoginManager.getInstance();
        usuarioManager = usuarioManager.getInstance();
        personagemManager = personagemManager.getInstance();
        partidaManager = partidaManager.getInstance();

        int choice = Integer.parseInt(option);
        switch (choice) {

            case 1:
                String name = "";
                String pass = "";

                name = JOptionPane.showInputDialog("Nome do usuario:");
                pass = JOptionPane.showInputDialog("Senha do usuario:");

                comandoAtual = new CadastrarUsuarioCommand(this,name,pass);
                break;

            case 2:
                comandoAtual = new ListarUsuariosCommand(this);
                break;

            case 3:
                String id = "";
                id = JOptionPane.showInputDialog("ID do usuario:");
                comandoAtual = new DeletarUsuarioCommand(this, Integer.parseInt(id));
                break;

            case 4:
                id = "";

                id = JOptionPane.showInputDialog("ID do usuario:");
                name = JOptionPane.showInputDialog("Nome do usuario:");
                pass = JOptionPane.showInputDialog("Senha do usuario:");

                comandoAtual = new AtualizarUsuarioCommand(this, Integer.parseInt(id),name,pass);
                break;

            case 5:
                comandoAtual = new ListarPartidasCommand(this);
                break;

            case 6:
                comandoAtual = new ListarPersonagensCommand(this);
                break;

            case 7:
                if(this.loginManager.isLogged()) {
                    JOptionPane.showMessageDialog(null, "Você já está logado");
                } else {
                    String login = "";
                    String senha = "";

                    login = JOptionPane.showInputDialog("Nome do usuario:");
                    senha = JOptionPane.showInputDialog("Senha do usuario:");

                    comandoAtual = new LoginCommand(this, login, senha);
                }
                break;

                case 8:
                    comandoAtual = new GerarRelatorioHtmlCommand(this);
                break;

                case 9:
                    comandoAtual = new GerarRelatorioPdfCommand(this);
                break;

                case 10:
                    comandoAtual = new LogoutCommand(this);
                break;
        }
            comandoAtual.execute();
    }

    //Corrigir excessões, precisa salvar o valor atual do nome ou pedir os dois novamente.
    public void cadastrarUsuario(Boolean cadastrado,Boolean checkedLogin, Boolean checkedPassword, String mensagemErro){
        String name = "";
        String pass = "";
        if (!cadastrado) {
            if (!checkedLogin) {
                JOptionPane.showMessageDialog(null, mensagemErro);
                name = JOptionPane.showInputDialog("Nome do usuario:");
                pass = JOptionPane.showInputDialog("Senha do usuario:");
            }
            if (!checkedPassword) {
                JOptionPane.showMessageDialog(null, mensagemErro);
                name = JOptionPane.showInputDialog("Nome do usuario:");
                pass = JOptionPane.showInputDialog("Senha do usuario:");
            }

            comandoAtual = new CadastrarUsuarioCommand(this,name,pass);
        }else {
            JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
            showMenu();
        }
    }

    public void listarUsuarios(Map<Integer, Usuario> users){
        ListAdapter listAdapter = new ListAdapter(users);
        JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaUsuario());

        JOptionPane.showMessageDialog(null, barraRolagem, "Usuarios", JOptionPane.INFORMATION_MESSAGE);
        showMenu();
    }

    public void deletarUsuario(){
        JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso!");
        showMenu();
    }

    public void atualizarUsuario(Integer id, Boolean cadastrado,Boolean checkedLogin, Boolean checkedPassword, String mensagemErro){
        String name = "";
        String pass = "";

        if (!cadastrado) {
            if (!checkedLogin) {
                JOptionPane.showMessageDialog(null, mensagemErro);
                name = JOptionPane.showInputDialog("Nome do usuario:");
                pass = JOptionPane.showInputDialog("Senha do usuario:");
            }
            if (!checkedPassword) {
                JOptionPane.showMessageDialog(null, mensagemErro);
                name = JOptionPane.showInputDialog("Nome do usuario:");
                pass = JOptionPane.showInputDialog("Senha do usuario:");
            }
            comandoAtual = new AtualizarUsuarioCommand(this,id,name, pass);
        }else {
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
            showMenu();
        }
    }
    public void listarPartidas(Map<Integer, Partida> partidas, Boolean sucesso, String mensagemErro){
        ListAdapter listAdapter = new ListAdapter(partidas);
        JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaPartida());

        if (sucesso) {
            JOptionPane.showMessageDialog(null, barraRolagem, "Partidas", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, mensagemErro);
        }
            showMenu();
    }

    public void listarPersonagens(Map<Integer, Personagem> personagens, Boolean sucesso, String mensagemErro){
        ListAdapter listAdapter = new ListAdapter(personagens);
        JScrollPane barraRolagem = new JScrollPane(listAdapter.criaListaPersonagem());

        if (sucesso) {
            JOptionPane.showMessageDialog(null, barraRolagem, "Personagens", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, mensagemErro);
        }
        showMenu();
    }

    public void realizarLogin(Boolean sucesso, String mensagemErro){
        if (sucesso){
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, mensagemErro);
        }
        showMenu();
    }

    public void gerarRelatorio(){
        JOptionPane.showMessageDialog(null, "Relatorio Gerado");
        showMenu();
    }

    public void realizarLogout(){
        JOptionPane.showMessageDialog(null, "Logout Realizado com Sucesso!");
    }
}
