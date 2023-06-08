package main.java.view.screenStates.ataquesStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.ataquesCommands.AtualizarAtaqueCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarAtaqueScreenState extends JFrame implements ScreenState {
    private JTextField textId,textNome,textDistancia,textDadiPerd,textDano,textCritico,textDescricao;
    private JComboBox<String> dropdownAtaque,dropdownContra;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Ataque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresAtaque = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO",  "DEFESA", "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO", "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtaque = new JComboBox<>(valoresAtaque);
        dropdownContra = new JComboBox<>(valoresAtaque);

        JLabel labelId = new JLabel("Id para atualizar:");
        JLabel labelNome= new JLabel("Nome do Ataque:");
        JLabel labelDistancia = new JLabel("Distancia:");
        JLabel labelAtaque = new JLabel("Ataque:");
        JLabel labelContra = new JLabel("Contra:");
        JLabel labelDadiPerd = new JLabel("Dadivas/Perdições:");
        JLabel labelDano = new JLabel("Dano:");
        JLabel labelCritico = new JLabel("Critico:");
        JLabel labelDescricao = new JLabel("Descrição:");
        textId = new JTextField(5);
        textNome = new JTextField(20);
        textDistancia = new JTextField(20);
        textDadiPerd = new JTextField(20);
        textDano = new JTextField(20);
        textCritico = new JTextField(20);
        textDescricao = new JTextField(20);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelId);
        panel.add(textId);
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
                Integer id = Integer.parseInt(textId.getText());
                /*String nome = textNome.getText();
                String distancia = textDistancia.getText();
                String tipoAtaque = (String) dropdownAtaque.getSelectedItem();
                String contraAtaque = (String) dropdownContra.getSelectedItem();
                Integer dadiPerd = Integer.parseInt(textDadiPerd.getText());
                String dano = textDano.getText();
                String critico = textCritico.getText();
                String descricao = textDescricao.getText();

                 */
                Command atualizarAtaqueCommand = new AtualizarAtaqueCommand(screen,id);
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
}

