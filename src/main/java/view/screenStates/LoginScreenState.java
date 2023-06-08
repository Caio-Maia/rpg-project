package main.java.view.screenStates;

import main.java.view.commands.usuariosCommands.CadastrarUsuarioCommand;
import main.java.view.commands.Command;
import main.java.view.commands.usuariosCommands.LoginCommand;
import main.java.view.MainScreenDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreenState extends JFrame implements ScreenState {
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelTexto = new JLabel("Insira usuário e senha para logar ou registrar-se");
        JLabel labelUsuario = new JLabel("Usuário:");
        JLabel labelSenha = new JLabel("Senha:");
        textFieldUsuario = new JTextField(20);
        passwordFieldSenha = new JPasswordField(20);
        JButton loginBtn = new JButton("Login");
        JButton registrarBtn = new JButton("Registrar-se");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(labelTexto);
        panel.add(labelUsuario);
        panel.add(textFieldUsuario);
        panel.add(labelSenha);
        panel.add(passwordFieldSenha);
        panel.add(registrarBtn);
        panel.add(loginBtn);

        getContentPane().add(panel);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acaoLoginBtn(screen);
            }
        });

        registrarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acaoRegistrarBtn(screen);
            }
        });

        setVisible(true);
    }

    @Override
    public void fechaTela(){
        this.setVisible(false);
    }

    private void acaoLoginBtn(MainScreenDesktop screen) {
        String login = textFieldUsuario.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        Command loginCommand = new LoginCommand(screen, login, senha);
        loginCommand.execute();
    }

    private void acaoRegistrarBtn(MainScreenDesktop screen) {
        String login = textFieldUsuario.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        Command registrarCommand = new CadastrarUsuarioCommand(screen, login, senha);
        registrarCommand.execute();
    }

}

