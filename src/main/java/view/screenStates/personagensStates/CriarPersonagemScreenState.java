package main.java.view.screenStates.personagensStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.personagensCommands.CriarPersonagemCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarPersonagemScreenState extends JFrame implements ScreenState {
    private JTextField textNome;
    private JTextField textCriador;
    private JTextField textPartida;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelNome= new JLabel("Nome do Personagem:");
        JLabel labelCriador = new JLabel("Id do Criador:");
        JLabel labelPartida = new JLabel("Id da Partida:");
        textNome = new JTextField(20);
        textCriador = new JTextField(5);
        textPartida = new JTextField(5);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelCriador);
        panel.add(textCriador);
        panel.add(labelPartida);
        panel.add(textPartida);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                Integer criador = Integer.parseInt(textCriador.getText());
                Integer partida = Integer.parseInt(textPartida.getText());

                Command criarPersonagemCommand = new CriarPersonagemCommand(screen,nome,criador,partida);
                criarPersonagemCommand.execute();
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
