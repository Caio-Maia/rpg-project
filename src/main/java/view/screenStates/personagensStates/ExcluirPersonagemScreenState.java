package main.java.view.screenStates.personagensStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.personagensCommands.DeletarPersonagemCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluirPersonagemScreenState extends JFrame implements ScreenState {
    private JTextField textPersonagemId;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Deletar Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelPersonagemId = new JLabel("Id do Personagem:");
        textPersonagemId = new JTextField(5);

        JButton AtualizarBtn = new JButton("Excluir");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelPersonagemId);
        panel.add(textPersonagemId);

        panel.add(AtualizarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        AtualizarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textPersonagemId.getText());

                Command deletarPersonagemCommand = new DeletarPersonagemCommand(screen,id);
                deletarPersonagemCommand.execute();
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
