package main.java.view.screenStates.itensStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.itensCommands.ListarItensCommands;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItensScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Itens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listar = new JButton("Listar Itens");
        JButton criar = new JButton("Criar Item");
        JButton atualizar = new JButton("Atualizar Item");
        JButton excluir = new JButton("Excluir Item");
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
                Command listarItensCommand = new ListarItensCommands(screen);
                listarItensCommand.execute();
            }
        });

        criar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarItemScreenState());
            }
        });

        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarItemScreenState());
            }
        });

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirItemScreenState());
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

