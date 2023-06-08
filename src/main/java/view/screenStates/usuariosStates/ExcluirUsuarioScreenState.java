package main.java.view.screenStates.usuariosStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.usuariosCommands.DeletarUsuarioCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcluirUsuarioScreenState extends JFrame implements ScreenState {

    private JTextField textFieldId;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Excluir Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("ID do Usuário:");
        textFieldId = new JTextField(5);

        JButton ExcluirBtn = new JButton("Excluir");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(labelId);
        panel.add(textFieldId);
        panel.add(ExcluirBtn);
        panel.add(VoltarBtn);

        add(panel);
        setVisible(true);

        ExcluirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textFieldId.getText());

                Command deletarUsuarioCommand = new DeletarUsuarioCommand(screen, id);
                deletarUsuarioCommand.execute();
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
