package main.java.view.screenStates.ataquesStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.ataquesCommands.ListarAtaquesCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtaquesScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Ataques");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listar = new JButton("Listar Ataques");
        JButton criar = new JButton("Criar Ataque");
        JButton atualizar = new JButton("Atualizar Ataque");
        JButton excluir = new JButton("Excluir Ataque");
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
                Command listarAtaquesCommand = new ListarAtaquesCommand(screen);
                listarAtaquesCommand.execute();
            }
        });

        criar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarAtaqueScreenState());
            }
        });

        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarAtaqueScreenState());
            }
        });

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirAtaqueScreenState());
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
