package main.java.view.screenStates.partidasStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.partidasCommands.AtualizarPartidaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarPartidaScreenState extends JFrame implements ScreenState {
    private JTextField textNome;
    private JTextField textId;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar partida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId= new JLabel("Id da partida:");
        textId = new JTextField(5);
        JLabel labelNome= new JLabel("Nome da partida:");
        textNome = new JTextField(20);

        JButton AtualizarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelId);
        panel.add(textId);
        panel.add(labelNome);
        panel.add(textNome);

        panel.add(AtualizarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        AtualizarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                Integer id = Integer.parseInt(textId.getText());

                Command atualizarPartidaCommand = new AtualizarPartidaCommand(screen,id,nome);
                atualizarPartidaCommand.execute();
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
