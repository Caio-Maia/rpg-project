package main.java.view.screenStates.magiasStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.ataquesCommands.ListarAtaquesCommand;
import main.java.view.commands.magiasCommands.ListarMagiasCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MagiasScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Magias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listar = new JButton("Listar Magias");
        JButton criar = new JButton("Criar Magia");
        JButton atualizar = new JButton("Atualizar Magia");
        JButton excluir = new JButton("Excluir Magia");
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
                Command listarMagiasCommand = new ListarMagiasCommand(screen);
                listarMagiasCommand.execute();
            }
        });

        criar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarMagiaScreenState());
            }
        });

        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirMagiaScreenState());
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
