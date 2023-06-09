package main.java.view.screenStates.itensStates;

import main.java.business.model.Item;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.itensCommands.AtualizarItemCommand;
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

public class AtualizarItemScreenState extends JFrame implements ScreenState {
    private JTextField textId,textNome,textDescricao,textQtdUsos,textQtd;
    private JLabel labelId,labelNome,labelDescricao,labelQtdUsos,labelQtd;
    private JCheckBox checkBox;
    private JButton atualizarBtn;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        checkBox = new JCheckBox("Tem Usos?");

        labelId = new JLabel("Id do Item:");
        textId = new JTextField(5);

        labelNome= new JLabel("Nome do Item:");
        labelDescricao = new JLabel("Descrição:");
        labelQtdUsos = new JLabel("Quantidade de Usos:");
        labelQtd = new JLabel("Quantidade:");
        textNome = new JTextField(20);
        textDescricao = new JTextField(20);
        textQtdUsos = new JTextField(5);
        textQtd = new JTextField(5);

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
                Integer qtd = Integer.parseInt(textQtd.getText());
                Boolean temUsos;
                Integer qtdUsos;

                if (checkBox.isSelected()){
                    temUsos = true;
                    qtdUsos = Integer.parseInt(textQtdUsos.getText());
                }else{
                    temUsos = false;
                    qtdUsos = -1;
                }

                Item item = new Item(nome,descricao,temUsos,qtdUsos,qtd);

                Command atualizarItemCommand = new AtualizarItemCommand(screen,id,item);
                atualizarItemCommand.execute();
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
        Map<Integer, Item> lista = screen.getItemManager().getItensByIds(ids);
        Item item = null;
        if (!lista.isEmpty()) {
            Iterator<Item> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                item = iterator.next();
                montarTela(panel,item);
            }
        }
    }

    private void montarTela(JPanel panel, Item item){
        textNome.setText(item.getNome());
        textDescricao.setText(item.getDescricao());
        checkBox.setSelected(item.getTemUsos());
        textQtdUsos.setText(item.getQuantidadeUsos().toString());
        textQtd.setText(item.getQuantidade().toString());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDescricao);
        panel.add(textDescricao);
        panel.add(checkBox);
        panel.add(labelQtdUsos);
        panel.add(textQtdUsos);
        panel.add(labelQtd);
        panel.add(textQtd);

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel){
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(labelDescricao);
        panel.remove(textDescricao);
        panel.remove(checkBox);
        panel.remove(labelQtdUsos);
        panel.remove(textQtdUsos);
        panel.remove(labelQtd);
        panel.remove(textQtd);

        panel.remove(atualizarBtn);
        panel.updateUI();
    }

}


