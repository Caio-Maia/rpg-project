package main.java.view.screenStates.magiasStates;

import main.java.business.model.Magia;
import main.java.business.model.enums.TipoAtaque;
import main.java.business.model.enums.TipoMagia;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.magiasCommands.AtualizarMagiaCommand;
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

public class AtualizarMagiaScreenState extends JFrame implements ScreenState {
    private JTextField textId,textNome,textTradicao,textAlvo,textDano,textCritico,textDuracao,textEfeito,textDescricao,textNivel,textQtdConj;
    private JLabel labelId, labelNome,labelTradicao,labelAlvo,labelDano,labelCritico,labelDuracao,labelEfeito,labelDescricao,labelTipoMag,labelAtaque,labelContra,labelNivel,labelQtdConj;
    private JComboBox<String> dropdownAtaque,dropdownContra,dropdownTipoMagia;
    private JButton atualizarBtn;

    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Magia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresTipoMag ={"ATAQUE,UTILIDADE"};
        String[] valoresAtaque = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO",  "DEFESA", "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO", "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtaque = new JComboBox<>(valoresAtaque);
        dropdownContra = new JComboBox<>(valoresAtaque);
        dropdownTipoMagia = new JComboBox<>(valoresTipoMag);

        labelId = new JLabel("Id da Magia:");
        labelNome= new JLabel("Nome da Magia:");
        labelTradicao = new JLabel("Tradição:");
        labelAlvo = new JLabel("Alvo:");
        labelDano = new JLabel("Dano:");
        labelCritico = new JLabel("Critico:");
        labelDuracao = new JLabel("Duração:");
        labelEfeito = new JLabel("Efeito:");
        labelDescricao = new JLabel("Descrição:");
        labelTipoMag = new JLabel("Tipo:");
        labelAtaque = new JLabel("Ataque:");
        labelContra = new JLabel("Contra:");
        labelNivel = new JLabel("Nivel:");
        labelQtdConj = new JLabel("Qtd Conjurações:");

        textId = new JTextField(5);
        textNome = new JTextField(20);
        textTradicao = new JTextField(20);
        textAlvo = new JTextField(20);
        textDano = new JTextField(20);
        textCritico = new JTextField(20);
        textDuracao = new JTextField(20);
        textEfeito = new JTextField(20);
        textDescricao = new JTextField(20);
        textNivel = new JTextField(5);
        textQtdConj = new JTextField(5);

        atualizarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

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
                String tradicao = textTradicao.getText();
                String tipoMagia = (String) dropdownTipoMagia.getSelectedItem();
                Integer nivel = Integer.parseInt(textNivel.getText());
                String alvo = textAlvo.getText();
                String dano = textDano.getText();
                String critico = textCritico.getText();
                String duracao = textDuracao.getText();
                String efeito = textEfeito.getText();
                String descricao = textDescricao.getText();
                String tipoAtaque = (String) dropdownAtaque.getSelectedItem();
                String contra = (String) dropdownContra.getSelectedItem();
                Integer qtdConj = Integer.parseInt(textQtdConj.getText());




                Magia magia = new Magia(nome,tradicao, TipoMagia.valueOf(tipoMagia),nivel,alvo,dano,critico,duracao,efeito,descricao, TipoAtaque.valueOf(tipoAtaque),TipoAtaque.valueOf(contra),qtdConj);

                Command atualizarMagiaCommand = new AtualizarMagiaCommand(screen,id,magia);
                atualizarMagiaCommand.execute();
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
        Map<Integer, Magia> lista = screen.getMagiaManager().getMagiasByIds(ids);
        Magia magia = null;
        if (!lista.isEmpty()) {
            Iterator<Magia> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                magia = iterator.next();
                montarTela(panel,magia);
            }
        }
    }

    private void montarTela(JPanel panel, Magia magia){
        textNome.setText(magia.getNome());
        textTradicao.setText(magia.getTradicao());
        textAlvo.setText(magia.getAlvo());
        textDano.setText(magia.getDano());
        textCritico.setText(magia.getCritico());
        textDuracao.setText(magia.getDuracao());
        textEfeito.setText(magia.getEfeito());
        textDescricao.setText(magia.getDescricao());
        dropdownTipoMagia.setSelectedIndex(magia.getTipoMagia().ordinal());
        dropdownAtaque.setSelectedIndex(magia.getTipoAtaque().ordinal());
        dropdownContra.setSelectedIndex(magia.getContraAtaque().ordinal());
        textNivel.setText(magia.getNivel().toString());
        textQtdConj.setText(magia.getQteConjuracoesRest().toString());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelTradicao);
        panel.add(textTradicao);
        panel.add(labelAlvo);
        panel.add(textAlvo);
        panel.add(labelDano);
        panel.add(textDano);
        panel.add(labelCritico);
        panel.add(textCritico);
        panel.add(labelDuracao);
        panel.add(textDuracao);
        panel.add(labelEfeito);
        panel.add(textEfeito);
        panel.add(labelDescricao);
        panel.add(textDescricao);
        panel.add(labelTipoMag);
        panel.add(dropdownTipoMagia);
        panel.add(labelAtaque);
        panel.add(dropdownAtaque);
        panel.add(labelContra);
        panel.add(dropdownContra);
        panel.add(labelNivel);
        panel.add(textNivel);
        panel.add(labelQtdConj);
        panel.add(textQtdConj);

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel) {
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(labelTradicao);
        panel.remove(textTradicao);
        panel.remove(labelAlvo);
        panel.remove(textAlvo);
        panel.remove(labelDano);
        panel.remove(textDano);
        panel.remove(labelCritico);
        panel.remove(textCritico);
        panel.remove(labelDuracao);
        panel.remove(textDuracao);
        panel.remove(labelEfeito);
        panel.remove(textEfeito);
        panel.remove(labelDescricao);
        panel.remove(textDescricao);
        panel.remove(labelTipoMag);
        panel.remove(dropdownTipoMagia);
        panel.remove(labelAtaque);
        panel.remove(dropdownAtaque);
        panel.remove(labelContra);
        panel.remove(dropdownContra);
        panel.remove(labelNivel);
        panel.remove(textNivel);
        panel.remove(labelQtdConj);
        panel.remove(textQtdConj);

        panel.remove(atualizarBtn);
        panel.updateUI();
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }
}
