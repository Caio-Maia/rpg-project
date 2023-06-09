package main.java.view.screenStates.ataquesStates;

import main.java.business.model.Ataque;
import main.java.business.model.enums.TipoAtaque;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.ataquesCommands.AtualizarAtaqueCommand;
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

public class AtualizarAtaqueScreenState extends JFrame implements ScreenState {
    private JTextField textId,textNome,textDistancia,textDadiPerd,textDano,textCritico,textDescricao;
    private JComboBox<String> dropdownAtaque,dropdownContra;

    JLabel labelId, labelNome,labelDistancia,labelAtaque,labelContra,labelDadiPerd,labelDano,labelCritico,labelDescricao;
    JButton atualizarBtn;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Ataque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresAtaque = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO",  "DEFESA", "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO", "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtaque = new JComboBox<>(valoresAtaque);
        dropdownContra = new JComboBox<>(valoresAtaque);

        labelId = new JLabel("Id para atualizar:");
        labelNome= new JLabel("Nome do Ataque:");
        labelDistancia = new JLabel("Distancia:");
        labelAtaque = new JLabel("Ataque:");
        labelContra = new JLabel("Contra:");
        labelDadiPerd = new JLabel("Dadivas/Perdições:");
        labelDano = new JLabel("Dano:");
        labelCritico = new JLabel("Critico:");
        labelDescricao = new JLabel("Descrição:");
        textId = new JTextField(5);
        textNome = new JTextField(20);
        textDistancia = new JTextField(20);
        textDadiPerd = new JTextField(20);
        textDano = new JTextField(20);
        textCritico = new JTextField(20);
        textDescricao = new JTextField(20);

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
                String distancia = textDistancia.getText();
                String tipoAtaque = (String) dropdownAtaque.getSelectedItem();
                String contraAtaque = (String) dropdownContra.getSelectedItem();
                Integer dadiPerd = Integer.parseInt(textDadiPerd.getText());
                String dano = textDano.getText();
                String critico = textCritico.getText();
                String descricao = textDescricao.getText();

                Ataque ataque = new Ataque(nome,distancia, TipoAtaque.valueOf(tipoAtaque),TipoAtaque.valueOf(contraAtaque),dadiPerd,dano,critico,descricao);

                Command atualizarAtaqueCommand = new AtualizarAtaqueCommand(screen,id,ataque);
                atualizarAtaqueCommand.execute();
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
        Map<Integer, Ataque> lista = screen.getAtaqueManager().getAtaquesByIds(ids);
        Ataque ataque = null;
        if (!lista.isEmpty()) {
            Iterator<Ataque> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                ataque = iterator.next();
                montarTela(panel,ataque);
            }
        }
    }

    private void montarTela(JPanel panel, Ataque ataque){
        textNome.setText(ataque.getNome());
        textDistancia.setText(ataque.getDistancia());
        dropdownAtaque.setSelectedIndex(ataque.getTipoAtaque().ordinal());
        dropdownContra.setSelectedIndex(ataque.getContraAtaque().ordinal());
        textDadiPerd.setText(ataque.getDadiPerd().toString());
        textDano.setText(ataque.getDano());
        textCritico.setText(ataque.getCritico());
        textDescricao.setText(ataque.getDescricao());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDistancia);
        panel.add(textDistancia);
        panel.add(labelAtaque);
        panel.add(dropdownAtaque);
        panel.add(labelContra);
        panel.add(dropdownContra);
        panel.add(labelDadiPerd);
        panel.add(textDadiPerd);
        panel.add(labelDano);
        panel.add(textDano);
        panel.add(labelCritico);
        panel.add(textCritico);
        panel.add(labelDescricao);
        panel.add(textDescricao);

        panel.add(atualizarBtn);
    }

    private void desmontaTela(JPanel panel){
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(labelDistancia);
        panel.remove(textDistancia);
        panel.remove(labelAtaque);
        panel.remove(dropdownAtaque);
        panel.remove(labelContra);
        panel.remove(dropdownContra);
        panel.remove(labelDadiPerd);
        panel.remove(textDadiPerd);
        panel.remove(labelDano);
        panel.remove(textDano);
        panel.remove(labelCritico);
        panel.remove(textCritico);
        panel.remove(labelDescricao);
        panel.remove(textDescricao);

        panel.remove(atualizarBtn);
    }

}

