package main.java.view.screenStates.equipamentosStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.equipamentoCommands.CriarEquipamentoCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarEquipamentosScreenState extends JFrame implements ScreenState {
    private JTextField textNome,textDefesa,textRequisito;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo Equipamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelNome= new JLabel("Nome do Equipamento:");
        JLabel labelDefesa = new JLabel("Defesa:");
        JLabel labelRequisito = new JLabel("Requisito:");
        textNome = new JTextField(20);
        textDefesa = new JTextField(20);
        textRequisito = new JTextField(20);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDefesa);
        panel.add(textDefesa);
        panel.add(labelRequisito);
        panel.add(textRequisito);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String defesa = textDefesa.getText();
                String requisito = textRequisito.getText();

                Command criarEquipamentoCommand = new CriarEquipamentoCommand(screen,nome,defesa,requisito);
                criarEquipamentoCommand.execute();
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
