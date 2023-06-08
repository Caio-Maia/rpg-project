package main.java.view.screenStates.armasStates;

import main.java.business.model.Arma;
import main.java.business.model.enums.Atributo;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.armasCommands.AtualizarArmaCommand;
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

public class AtualizarArmaScreenState extends JFrame implements ScreenState {
    private JTextField textId, textNome,textRequisito,textDano,textPropriedade;
    private JLabel labelNome,labelrequisito,labelAtributo,labelDano,labelPropriedade;
    private JComboBox<String> dropdownAtributo;
    private JButton AtualizarBtn;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Arma");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);


        String[] valoresAtributos = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO", "DEFESA",
                "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO",
                "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtributo = new JComboBox<>(valoresAtributos);

        JLabel labelId = new JLabel("Id da arma:");
        labelNome = new JLabel("Nome:");
        labelrequisito = new JLabel("Requisito:");
        labelAtributo = new JLabel("Atributo:");
        labelDano = new JLabel("Dano:");
        labelPropriedade = new JLabel("Propriedade:");

        textId = new JTextField(5);
        textNome = new JTextField(20);
        textRequisito = new JTextField(20);
        textDano = new JTextField(20);
        textPropriedade = new JTextField(20);


        AtualizarBtn = new JButton("Atualizar");
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
        AtualizarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textId.getText());
                String nome = textNome.getText();
                String requisito = textRequisito.getText();
                String atributo = (String) dropdownAtributo.getSelectedItem();
                String dano = textDano.getText();
                String propriedades = textPropriedade.getText();

                Arma arma = new Arma(nome,requisito, Atributo.valueOf(atributo),dano,propriedades);

                Command atualizarArmaCommand = new AtualizarArmaCommand(screen,id,arma);
                atualizarArmaCommand.execute();
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

    private void busca(Integer textoDigitado,MainScreenDesktop screen, JPanel panel){
        List ids = new ArrayList<>();
        ids.add(textoDigitado);
        Map<Integer,Arma> listaArma = screen.getArmaManager().getArmasByIds(ids);
        Arma arma = null;
        if (!listaArma.isEmpty()) {
            Iterator<Arma> iterator = listaArma.values().iterator();
            if (iterator.hasNext()) {
                arma = iterator.next();
                montarTela(panel,arma);
            }
        }
    }
    private void montarTela(JPanel panel, Arma arma){
        textNome.setText(arma.getNome());
        textRequisito.setText(arma.getRequisito());
        dropdownAtributo.setSelectedIndex(arma.getAtributo().ordinal());
        textDano.setText(arma.getDano());
        textPropriedade.setText(arma.getPropriedades());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelrequisito);
        panel.add(textRequisito);
        panel.add(labelAtributo);
        panel.add(dropdownAtributo);
        panel.add(labelDano);
        panel.add(textDano);
        panel.add(labelPropriedade);
        panel.add(textPropriedade);

        panel.add(AtualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel){
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(labelrequisito);
        panel.remove(textRequisito);
        panel.remove(labelAtributo);
        panel.remove(dropdownAtributo);
        panel.remove(labelDano);
        panel.remove(textDano);
        panel.remove(labelPropriedade);
        panel.remove(textPropriedade);

        panel.remove(AtualizarBtn);
        panel.updateUI();
    }
}
