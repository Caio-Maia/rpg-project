package main.java.view.screenStates.partidasStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.partidasCommands.CriarPartidaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarPartidaScreenState extends JFrame implements ScreenState {
    private JTextField textNome;
    private JTextField textMestre;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar nova partida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelNome= new JLabel("Nome da partida:");
        JLabel labelMestre = new JLabel("Mestre da partida:");
        textNome = new JTextField(20);
        textMestre = new JTextField(5);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelMestre);
        panel.add(textMestre);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                Integer mestre = Integer.parseInt(textMestre.getText());

                Command criarPartidaCommand = new CriarPartidaCommand(screen,nome,mestre);
                criarPartidaCommand.execute();
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
