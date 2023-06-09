package main.java.view.screenStates.equipamentosStates;

import main.java.business.model.Equipamento;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.equipamentoCommands.AtualizarEquipamentoCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AtualizarEquipamentoScreenState extends JFrame implements ScreenState {
    private JLabel labelNome,labelDefesa,labelRequisito;
    private JTextField textId,textNome,textDefesa,textRequisito;
    private JButton atualizarBtn;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Equipamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("Id do equipamento:");
        labelNome= new JLabel("Nome do Equipamento:");
        labelDefesa = new JLabel("Defesa:");
        labelRequisito = new JLabel("Requisito:");

        textNome = new JTextField(20);
        textDefesa = new JTextField(20);
        textRequisito = new JTextField(20);

        atualizarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelId);
        panel.add(textId);

        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        textId.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                desmontaTela(panel);
                String entrada = textId.getText();
                if (entrada.matches("-?\\d+")) {
                    Integer textoDigitado = Integer.parseInt(entrada);
                    busca(textoDigitado, screen, panel);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                desmontaTela(panel);
                String entrada = textId.getText();
                if (entrada.matches("-?\\d+")) {
                    Integer textoDigitado = Integer.parseInt(entrada);
                    busca(textoDigitado, screen, panel);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        atualizarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textId.getText());
                String nome = textNome.getText();
                String defesa = textDefesa.getText();
                String requisito = textRequisito.getText();

                Equipamento equipamento = new Equipamento(nome,defesa,requisito);

                Command atualizarEquipamentoCommand = new AtualizarEquipamentoCommand(screen,id,equipamento);
                atualizarEquipamentoCommand.execute();
            }
        });

        VoltarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command voltarTelaCommand = new VoltarTelaCommand(screen);
                voltarTelaCommand.execute();
            }
        });
    }

    private void busca(Integer textoDigitado, MainScreenDesktop screen, JPanel panel) {
        List ids = new ArrayList<>();
        ids.add(textoDigitado);
        Map<Integer, Equipamento> lista = screen.getEquipamentoManager().getEquipamentosByIds(ids);
        Equipamento equipamento = null;
        if (!lista.isEmpty()) {
            Iterator<Equipamento> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                equipamento = iterator.next();
                montarTela(panel,equipamento);
            }
        }
    }

    private void montarTela(JPanel panel, Equipamento equipamento) {
        textNome.setText(equipamento.getNome());
        textDefesa.setText(equipamento.getDefesa());
        textRequisito.setText(equipamento.getRequisito());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDefesa);
        panel.add(textDefesa);
        panel.add(labelRequisito);
        panel.add(textRequisito);

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel) {
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(labelDefesa);
        panel.remove(textDefesa);
        panel.remove(labelRequisito);
        panel.remove(textRequisito);

        panel.remove(atualizarBtn);
        panel.updateUI();
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }
}
