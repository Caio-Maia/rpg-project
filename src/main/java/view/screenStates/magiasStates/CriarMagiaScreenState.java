package main.java.view.screenStates.magiasStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.magiasCommands.CriarMagiaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarMagiaScreenState extends JFrame implements ScreenState {
    private JTextField textNome,textTradicao,textAlvo,textDano,textCritico,textDuracao,textEfeito,textDescricao,textNivel,textQtdConj;
    private JComboBox<String> dropdownAtaque,dropdownContra,dropdownTipoMagia;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar nova Magia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresTipoMag ={"ATAQUE,UTILIDADE"};
        String[] valoresAtaque = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO",  "DEFESA", "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO", "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtaque = new JComboBox<>(valoresAtaque);
        dropdownContra = new JComboBox<>(valoresAtaque);
        dropdownTipoMagia = new JComboBox<>(valoresTipoMag);

        JLabel labelNome= new JLabel("Nome da Magia:");
        JLabel labelTradicao = new JLabel("Tradição:");
        JLabel labelAlvo = new JLabel("Alvo:");
        JLabel labelDano = new JLabel("Dano:");
        JLabel labelCritico = new JLabel("Critico:");
        JLabel labelDuracao = new JLabel("Duração:");
        JLabel labelEfeito = new JLabel("Efeito:");
        JLabel labelDescricao = new JLabel("Descrição:");
        JLabel labelTipoMag = new JLabel("Tipo:");
        JLabel labelAtaque = new JLabel("Ataque:");
        JLabel labelContra = new JLabel("Contra:");
        JLabel labelNivel = new JLabel("Nivel:");
        JLabel labelQtdConj = new JLabel("Qtd Conjurações:");

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

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

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

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String tradicao = textTradicao.getText();
                String alvo = textAlvo.getText();
                String dano = textDano.getText();
                String critico = textCritico.getText();
                String duracao = textDuracao.getText();
                String efeito = textEfeito.getText();
                String descricao = textDescricao.getText();
                String tipoMagia = (String) dropdownTipoMagia.getSelectedItem();
                String tipoAtaque = (String) dropdownAtaque.getSelectedItem();
                String contraAtaque = (String) dropdownContra.getSelectedItem();
                Integer nivel = Integer.parseInt(textNivel.getText());
                Integer qtdConj = Integer.parseInt(textQtdConj.getText());


                Command criarMagiaCommand = new CriarMagiaCommand(screen,nome,tradicao,alvo,dano,critico,duracao,efeito,descricao,tipoMagia,tipoAtaque,contraAtaque,nivel,qtdConj);
                criarMagiaCommand.execute();
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

