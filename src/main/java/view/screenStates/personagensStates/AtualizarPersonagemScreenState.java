package main.java.view.screenStates.personagensStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.personagensCommands.AtualizarPersonagemCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarPersonagemScreenState extends JFrame implements ScreenState {
    private JTextField textNome;
    private JTextField textPartida;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelNome= new JLabel("Nome do Personagem:");
        JLabel labelPartida = new JLabel("Id da Partida:");
        textNome = new JTextField(20);
        textPartida = new JTextField(5);

        JButton AtualizarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelPartida);
        panel.add(textPartida);

        panel.add(AtualizarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        AtualizarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                Integer partida = Integer.parseInt(textPartida.getText());

                //Command atualizarPersonagemCommand = new AtualizarPersonagemCommand(screen,nome,partida);
                //atualizarPersonagemCommand.execute();
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
