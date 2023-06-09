package main.java.view.screenStates.statusStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.statusCommands.ListarStatusCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listar = new JButton("Listar Status");
        JButton criar = new JButton("Criar Status");
        JButton atualizar = new JButton("Atualizar Status");
        JButton excluir = new JButton("Excluir Status");
        JButton VoltarBtn = new JButton("Voltar");

        panel.add(listar);
        panel.add(criar);
        panel.add(atualizar);
        panel.add(excluir);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);


        listar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command listarStatusCommand = new ListarStatusCommand(screen);
                listarStatusCommand.execute();
            }
        });

        criar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarStatusScreenState());
            }
        });

        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarStatusScreenState());
            }
        });

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirStatusScreenState());
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
