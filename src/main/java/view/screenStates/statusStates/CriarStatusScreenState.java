package main.java.view.screenStates.statusStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.statusCommands.CriarStatusCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarStatusScreenState extends JFrame implements ScreenState {
    private JTextField textValor;
    private JCheckBox checkBox;
    private JComboBox<String> dropdownAtributo;
    private Boolean temModificador;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresAtributo = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO",  "DEFESA", "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO", "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtributo = new JComboBox<>(valoresAtributo);

        temModificador = false;
        checkBox = new JCheckBox("Tem Usos?");
        checkBox.setSelected(temModificador);

        JLabel labelAtributo= new JLabel("Atributo:");
        JLabel labelValor = new JLabel("Valor:");

        textValor = new JTextField(5);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelAtributo);
        panel.add(dropdownAtributo);
        panel.add(labelValor);
        panel.add(textValor);
        panel.add(checkBox);


        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String atributo = (String) dropdownAtributo.getSelectedItem();
                String valor = textValor.getText();

                if (checkBox.isSelected()){
                    temModificador = true;
                }else {
                    temModificador = false;
                }

                Command criarStatusCommand = new CriarStatusCommand(screen,atributo,valor,temModificador);
                criarStatusCommand.execute();
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
