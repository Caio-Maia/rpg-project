package main.java.view;

import main.java.business.control.PartidaManager;
import main.java.business.control.PersonagemManager;
import main.java.business.control.UsuarioManager;
import main.java.business.model.Partida;
import main.java.business.model.Personagem;
import main.java.business.model.Usuario;
import main.java.infra.InfraException;
import main.java.util.LoginInvalidException;
import main.java.util.PasswordInvalidException;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Iterator;


public class MainScreenDesktop {

    UsuarioManager usuarioManager;
    PersonagemManager personagemManager;
    PartidaManager partidaManager;

    public static void main(String[] args) throws SQLException {
        showMenu();
    }

    public static void showMenu() throws SQLException {
        String option = JOptionPane.showInputDialog("Bem vindo ao sistema!\nEscolha a opcao desejada:\n1-Cadastrar Usuario\n2-Listar Usuarios\n3-Excluir Usuario\n4-Atualizar Usuario\n5-Lista partidas\n6-Lista Personagens", "Sua opcao");

        MainScreenDesktop main = new MainScreenDesktop();

        main.readUserInput(option);
    }

    public void readUserInput(String option) throws SQLException {
        usuarioManager = usuarioManager.getInstance();
        personagemManager = personagemManager.getInstance();
        partidaManager = partidaManager.getInstance();

        int choice = Integer.parseInt(option);
        boolean checkedLogin = false;
        boolean checkedPassword = false;
        switch (choice) {

            case 1:

                while (true) {
                    String name = "";
                    String pass = "";

                    if (!checkedLogin) {
                        name = JOptionPane.showInputDialog("Nome do usuario:");

                    }
                    if (!checkedPassword) {
                        pass = JOptionPane.showInputDialog("Senha do usuario:");

                    }

                    try {
                        String[] args = {name, pass};
                        this.usuarioManager.addUsuario(args);
                        partidaManager.addPartida("Qualquer", 2);
                        personagemManager.addPersonagem(2, "Josesvaldo", 1);
                        JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
                        break;
                    } catch (LoginInvalidException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        checkedLogin = false;
                        checkedPassword = true;
                    } catch (PasswordInvalidException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        checkedLogin = true;
                        checkedPassword = false;
                    } catch (InfraException e) {
                        e.printStackTrace();
                    }

                }
                showMenu();
                break;

            case 2:
                String usuarios = "";
                Iterator<Usuario> users;
                try {
                    users = this.usuarioManager.getAllClients().values().iterator();
                    while (users.hasNext()) {
                        Usuario usuario = users.next();
                        usuarios = usuarios + "[ ID: " + usuario.getId() + " || Login: " + usuario.getLogin() + " || Senha: " + usuario.getSenha() + " ]" + "\n";
                    }
                    JOptionPane.showMessageDialog(null, usuarios);
                } catch (InfraException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


                showMenu();
                break;
            case 3:
                String id = "";
                id = JOptionPane.showInputDialog("ID do usuario:");
                this.usuarioManager.deleteUsuario(Integer.parseInt(id));
                showMenu();
                break;
            case 4:
                id = "";
                id = JOptionPane.showInputDialog("ID do usuario:");

                while (true) {
                    String name = "";
                    String pass = "";

                    if (!checkedLogin) {
                        name = JOptionPane.showInputDialog("Nome do usuario:");

                    }
                    if (!checkedPassword) {
                        pass = JOptionPane.showInputDialog("Senha do usuario:");

                    }

                    try {
                        String[] args = {name, pass};
                        this.usuarioManager.updateUsuario(Integer.parseInt(id), args);
                        JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
                        break;
                    } catch (LoginInvalidException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        checkedLogin = false;
                        checkedPassword = true;
                    } catch (PasswordInvalidException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        checkedLogin = true;
                        checkedPassword = false;
                    }

                }
                showMenu();
                break;
            case 5:
                String partida = "";
                Iterator<Partida> partidas;
                try {
                    partidas = this.partidaManager.getAllPartidas().values().iterator();
                    while (partidas.hasNext()) {
                        Partida part = partidas.next();
                        partida = partida + "[ ID: " + part.getId() + " || Nome: " + part.getNome() + " || ID mestre: " + part.getMestre() + " ]" + "\n";
                    }
                    JOptionPane.showMessageDialog(null, partida);
                } catch (InfraException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


                showMenu();
                break;
            case 6:
                String personagem = "";
                Iterator<Personagem> personagens;
                try {
                    personagens = this.personagemManager.getAllPersonagens().values().iterator();
                    while (personagens.hasNext()) {
                        Personagem person = personagens.next();
                        personagem = personagem + "[ ID: " + person.getId() + " || Nome: " + person.getNome() + " || ID criador: " + person.getCriador() + " ID Partida: " + person.getPartida() + " ]" + "\n";
                    }
                    JOptionPane.showMessageDialog(null, personagem);
                } catch (InfraException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


                showMenu();
                break;
        }
    }
}