package main.java.view.screenStates.talentosStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.talentosCommands.ListarTalentosCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TalentosScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Talentos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listar = new JButton("Listar Talentos");
        JButton criar = new JButton("Criar Talento");
        JButton atualizar = new JButton("Atualizar Talento");
        JButton excluir = new JButton("Excluir Talento");
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
                Command listarTalentosCommand = new ListarTalentosCommand(screen);
                listarTalentosCommand.execute();
            }
        });

        criar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarTalentoScreenState());
            }
        });

        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarTalentoScreenState());
            }
        });

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirTalentosScreenState());
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
