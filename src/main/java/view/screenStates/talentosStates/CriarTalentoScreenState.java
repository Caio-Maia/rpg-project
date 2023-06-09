package main.java.view.screenStates.talentosStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.talentosCommands.CriarTalentoCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarTalentoScreenState extends JFrame implements ScreenState {
    private JTextField textNome,textDescricao,textQtdConjMax,textQtdConjRest;
    private JCheckBox checkBox;
    private boolean temConj;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo Talento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        temConj = false;
        checkBox = new JCheckBox("Tem conjurações");
        checkBox.setSelected(temConj);

        JLabel labelNome= new JLabel("Nome do Talento:");
        JLabel labelDescricao = new JLabel("Descrição:");
        JLabel labelConjMax = new JLabel("Qtd max de conjurações:");
        JLabel labelConjRest = new JLabel("Qtd restante de conjurações:");

        textNome = new JTextField(20);
        textDescricao = new JTextField(20);
        textQtdConjMax = new JTextField(5);
        textQtdConjRest = new JTextField(5);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(textDescricao);
        panel.add(checkBox);
        panel.add(labelConjMax);
        panel.add(textQtdConjMax);
        panel.add(labelConjRest);
        panel.add(textQtdConjRest);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String descricao = textDescricao.getText();
                Integer qtdConjMax;
                Integer qtdConjRest;

                if(checkBox.isSelected()){
                    temConj = true;
                    qtdConjMax = Integer.parseInt(textQtdConjMax.getText());
                    qtdConjRest = Integer.parseInt(textQtdConjRest.getText());
                }else {
                    temConj = true;
                    qtdConjMax = -1;
                    qtdConjRest = -1;
                }

                Command criarTalentoCommand = new CriarTalentoCommand(screen,nome,descricao,temConj,qtdConjMax,qtdConjRest);
                criarTalentoCommand.execute();
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
