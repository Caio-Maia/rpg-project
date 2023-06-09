package main.java.view.screenStates.partidasStates;

import main.java.view.commands.Command;
import main.java.view.commands.partidasCommands.ListarPartidasCommand;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartidasScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Partidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listarPartidas = new JButton("Listar Partidas");
        JButton criarPartida = new JButton("Criar Partida");
        JButton atualizarPartida = new JButton("Atualizar Partida");
        JButton excluirPartida = new JButton("Excluir Partida");
        JButton VoltarBtn = new JButton("Voltar");

        panel.add(listarPartidas);
        panel.add(criarPartida);
        panel.add(atualizarPartida);
        panel.add(excluirPartida);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);


        listarPartidas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command listarPartidasCommand = new ListarPartidasCommand(screen);
                listarPartidasCommand.execute();
            }
        });

        criarPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarPartidaScreenState());
            }
        });

        atualizarPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarPartidaScreenState());
            }
        });

        excluirPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirPartidaScreenState());
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
