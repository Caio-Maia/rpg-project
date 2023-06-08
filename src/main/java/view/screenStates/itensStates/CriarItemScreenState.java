package main.java.view.screenStates.itensStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.itensCommands.CriarItemCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarItemScreenState extends JFrame implements ScreenState {
    private JTextField textNome,textDescricao,textQtdUsos,textQtd;
    private JCheckBox checkBox;
    private Boolean temUsos;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        temUsos = false;
        checkBox = new JCheckBox("Tem Usos?");
        checkBox.setSelected(temUsos);


        JLabel labelNome= new JLabel("Nome do Item:");
        JLabel labelDescricao = new JLabel("Descrição:");
        JLabel labelQtdUsos = new JLabel("Quantidade de Usos:");
        JLabel labelQtd = new JLabel("Quantidade:");
        textNome = new JTextField(20);
        textDescricao = new JTextField(256);
        textQtdUsos = new JTextField(5);
        textQtd = new JTextField(5);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDescricao);
        panel.add(textDescricao);
        panel.add(checkBox);
        panel.add(labelQtdUsos);
        panel.add(textQtdUsos);
        panel.add(labelQtd);
        panel.add(textQtd);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String descricao = textDescricao.getText();
                Integer qtd = Integer.parseInt(textQtd.getText());
                Integer qtdUsos;

                if (checkBox.isSelected()){
                    temUsos = true;
                    qtdUsos = Integer.parseInt(textQtdUsos.getText());
                }else {
                    temUsos = false;
                    qtdUsos = -1;
                }

                Command criarItemCommand = new CriarItemCommand(screen,nome,descricao,temUsos,qtdUsos,qtd);
                criarItemCommand.execute();
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
