package main.java.view.screenStates.talentosStates;

import main.java.business.model.Talento;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.talentosCommands.AtualizarTalentoCommand;
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

public class AtualizarTalentoScreenState extends JFrame implements ScreenState {
    private JTextField textId,textNome,textDescricao,textQtdConjMax,textQtdConjRest;
    private JLabel labelNome,labelDescricao,labelConjRest,labelConjMax;
    private JCheckBox checkBox;
    private JButton atualizarBtn;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Talento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId= new JLabel("Id do Status:");
        textId = new JTextField(5);

        checkBox = new JCheckBox("Tem conjurações");

        labelNome= new JLabel("Nome do Talento:");
        labelDescricao = new JLabel("Descrição:");
        labelConjRest = new JLabel("Qtd restante de conjurações:");
        labelConjMax = new JLabel("Qtd max de conjurações:");
        textNome = new JTextField(20);
        textDescricao = new JTextField(20);
        textQtdConjMax = new JTextField(5);
        textQtdConjRest = new JTextField(5);


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
                String descricao = textDescricao.getText();
                Boolean temConjuracoes;
                Integer qtdConjRest,qtdConjMax;

                if (checkBox.isSelected()){
                    temConjuracoes = true;
                    qtdConjMax = Integer.parseInt(textQtdConjMax.getText());
                    qtdConjRest = Integer.parseInt(textQtdConjRest.getText());
                }else {
                    temConjuracoes = false;
                    qtdConjMax = -1;
                    qtdConjRest = -1;
                }

                Talento talento = new Talento(nome,descricao,temConjuracoes,qtdConjMax,qtdConjRest);

                Command atualizarTalentoCommand = new AtualizarTalentoCommand(screen,id,talento);
                atualizarTalentoCommand.execute();
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
        Map<Integer, Talento> lista = screen.getTalentoManager().getTalentosByIds(ids);
        Talento talento = null;
        if (!lista.isEmpty()) {
            Iterator<Talento> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                talento = iterator.next();
                montarTela(panel,talento);
            }
        }
    }

    private void montarTela(JPanel panel, Talento talento){
        textNome.setText(talento.getNome());
        textDescricao.setText(talento.getDescricao());
        checkBox.setSelected(talento.getTemConjuracoes());
        textQtdConjMax.setText(talento.getQteConjuracoesMax().toString());
        textQtdConjRest.setText(talento.getQteConjuracoesRest().toString());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(textDescricao);
        panel.add(checkBox);
        panel.add(labelConjMax);
        panel.add(textQtdConjMax);
        panel.add(labelConjRest);
        panel.add(textQtdConjRest);

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel){
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(textDescricao);
        panel.remove(checkBox);
        panel.remove(labelConjMax);
        panel.remove(textQtdConjMax);
        panel.remove(labelConjRest);
        panel.remove(textQtdConjRest);

        panel.remove(atualizarBtn);
        panel.updateUI();
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }
}
