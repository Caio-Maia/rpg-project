package main.java.view.screenStates.usuariosStates;

import main.java.view.commands.Command;
import main.java.view.commands.usuariosCommands.ListarUsuariosCommand;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuariosScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Usuários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton ListarUsBtn = new JButton("Listar Usuários");
        JButton ExcluirUsBtn = new JButton("Excluir Usuário");
        JButton AtualizarUsBtn = new JButton("Atualizar Usuário");
        JButton VoltarBtn = new JButton("Voltar");

        panel.add(ListarUsBtn);
        panel.add(ExcluirUsBtn);
        panel.add(AtualizarUsBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        ListarUsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command listarUsuariosCommand = new ListarUsuariosCommand(screen);
                listarUsuariosCommand.execute();
            }
        });

        ExcluirUsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirUsuarioScreenState());
            }
        });

        AtualizarUsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarUsuariosScreenState());
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
