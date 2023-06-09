package main.java.view.screenStates.statusStates;

import main.java.business.model.Status;
import main.java.business.model.enums.Atributo;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.statusCommands.AtualizarStatusCommand;
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

public class AtualizarStatusScreenState extends JFrame implements ScreenState {
    private JTextField textId,textValor;
    private JLabel labelValor;
    private JCheckBox checkBox;
    private JButton atualizarBtn;
    private Atributo atributo;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Status");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        checkBox = new JCheckBox("Tem Modificador?");

        JLabel labelId= new JLabel("Id do Status:");
        labelValor = new JLabel("Valor:");
        textId = new JTextField(5);
        textValor = new JTextField(5);

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
                String valor = textValor.getText();
                Boolean temModificador;

                if (checkBox.isSelected()){
                    temModificador = true;
                }else {
                    temModificador = false;
                }

                Status status = new Status(atributo,valor,temModificador);

                Command atualizarStatusCommand = new AtualizarStatusCommand(screen,id,status);
                atualizarStatusCommand.execute();
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
        Map<Integer, Status> lista = screen.getStatusManager().getStatusesByIds(ids);
        Status status = null;
        if (!lista.isEmpty()) {
            Iterator<Status> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                status = iterator.next();
                montarTela(panel,status);
            }
        }
    }

    private void montarTela(JPanel panel, Status status){
        atributo = status.getAtributo();
        textValor.setText(status.getValor());
        checkBox.setSelected(status.getTemModificador());

        panel.add(labelValor);
        panel.add(textValor);
        panel.add(checkBox);

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel){
        panel.remove(labelValor);
        panel.remove(textValor);
        panel.remove(checkBox);

        panel.remove(atualizarBtn);
        panel.updateUI();
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }
}
