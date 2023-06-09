package main.java.view.screenStates.statusStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.statusCommands.DeletarStatusCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluirStatusScreenState extends JFrame implements ScreenState {
    private JTextField textId;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Excluir Status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("ID do Status:");
        textId = new JTextField(5);

        JButton ExcluirBtn = new JButton("Excluir");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(labelId);
        panel.add(textId);
        panel.add(ExcluirBtn);
        panel.add(VoltarBtn);

        add(panel);
        setVisible(true);

        ExcluirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textId.getText());

                Command deletarStatusCommand = new DeletarStatusCommand(screen, id);
                deletarStatusCommand.execute();
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
