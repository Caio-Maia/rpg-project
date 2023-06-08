package main.java.view.screenStates.usuariosStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.usuariosCommands.AtualizarUsuarioCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarUsuariosScreenState extends JFrame implements ScreenState {
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;
    private JTextField textFieldId;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("ID do Usuário:");
        textFieldId = new JTextField(5);
        JLabel labelUsuario = new JLabel("Usuário:");
        JLabel labelSenha = new JLabel("Senha:");
        textFieldUsuario = new JTextField(20);
        passwordFieldSenha = new JPasswordField(20);
        JButton AtualizarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(labelId);
        panel.add(textFieldId);
        panel.add(labelUsuario);
        panel.add(textFieldUsuario);
        panel.add(labelSenha);
        panel.add(passwordFieldSenha);
        panel.add(AtualizarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        AtualizarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textFieldId.getText());
                String usuario = textFieldUsuario.getText();
                String senha = new String(passwordFieldSenha.getPassword());

                Command atualizarUsuarioCommand = new AtualizarUsuarioCommand(screen,id,usuario,senha);
                atualizarUsuarioCommand.execute();
            }
        });

        VoltarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command voltarTelaCommand = new VoltarTelaCommand(screen);
                voltarTelaCommand.execute();
            }
        });
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }
}
