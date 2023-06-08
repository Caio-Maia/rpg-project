package main.java.view.screenStates.ataquesStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.ataquesCommands.CriarAtaqueCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarAtaqueScreenState extends JFrame implements ScreenState {
    private JTextField textNome,textDistancia,textDadiPerd,textDano,textCritico,textDescricao;
    private JComboBox<String> dropdownAtaque,dropdownContra;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo Ataque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresAtaque = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO",  "DEFESA", "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO", "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtaque = new JComboBox<>(valoresAtaque);
        dropdownContra = new JComboBox<>(valoresAtaque);

        JLabel labelNome= new JLabel("Nome do Ataque:");
        JLabel labelDistancia = new JLabel("Distancia:");
        JLabel labelAtaque = new JLabel("Ataque:");
        JLabel labelContra = new JLabel("Contra:");
        JLabel labelDadiPerd = new JLabel("Dadivas/Perdições:");
        JLabel labelDano = new JLabel("Dano:");
        JLabel labelCritico = new JLabel("Critico:");
        JLabel labelDescricao = new JLabel("Descrição:");
        textNome = new JTextField(20);
        textDistancia = new JTextField(20);
        textDadiPerd = new JTextField(20);
        textDano = new JTextField(20);
        textCritico = new JTextField(256);
        textDescricao = new JTextField(256);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

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

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String distancia = textDistancia.getText();
                String tipoAtaque = (String) dropdownAtaque.getSelectedItem();
                String contraAtaque = (String) dropdownContra.getSelectedItem();
                Integer dadiPerd = Integer.parseInt(textDadiPerd.getText());
                String dano = textDano.getText();
                String critico = textCritico.getText();
                String descricao = textDescricao.getText();

                Command criarAtaqueCommand = new CriarAtaqueCommand(screen,nome,distancia,tipoAtaque,contraAtaque,dadiPerd,dano,critico,descricao);
                criarAtaqueCommand.execute();
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
