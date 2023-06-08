package main.java.view.screenStates.armasStates;

import com.itextpdf.text.pdf.PdfAnnotation;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.armasCommands.AtualizarArmaCommand;
import main.java.view.commands.armasCommands.CriarArmaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarArmaScreenState extends JFrame implements ScreenState {
    private JTextField textId;
    private JTextField textNome;
    private JTextField textRequisito;
    private JComboBox<String> dropdownAtributo;
    private JTextField textDano;
    private JTextField textPropriedade;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar nova Arma");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresAtributos = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO", "DEFESA",
                "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO",
                "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtributo = new JComboBox<>(valoresAtributos);

        JLabel labelId = new JLabel("Id da arma:");
        JLabel labelNome= new JLabel("Nome da Arma:");
        JLabel labelRequisito = new JLabel("Requisito:");
        JLabel labelAtributo = new JLabel("Atributo:");
        JLabel labelDano = new JLabel("Dano:");
        JLabel labelPropriedade = new JLabel("Propriedade:");
        textId = new JTextField(5);
        textNome = new JTextField(20);
        textRequisito = new JTextField(20);
        textDano = new JTextField(20);
        textPropriedade = new JTextField(20);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelId);
        panel.add(textId);
        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelRequisito);
        panel.add(textRequisito);
        panel.add(labelAtributo);
        panel.add(dropdownAtributo);
        panel.add(labelDano);
        panel.add(textDano);
        panel.add(labelPropriedade);
        panel.add(textPropriedade);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textId.getText());
                String nome = textNome.getText();
                String requisito = textRequisito.getText();
                String atributo = (String) dropdownAtributo.getSelectedItem();
                String dano = textDano.getText();
                String propriedade = textPropriedade.getText();

                Command atualizarArmaCommand = new AtualizarArmaCommand(screen,id,nome,requisito,atributo,dano,propriedade);
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
}
