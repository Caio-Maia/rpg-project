package main.java.view.screenStates.armasStates;

import com.itextpdf.text.pdf.PdfAnnotation;
import main.java.business.model.enums.Atributo;
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
    private JTextField textId, textValor;
    private JComboBox<String> dropdownAtributo, dropdownVariavel;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Arma");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        String[] valoresVariavel = {"nome","requisito","atributo","dano","propriedades"};
        dropdownVariavel = new JComboBox<>(valoresVariavel);

        String[] valoresAtributos = {"FORÇA", "AGILIDADE", "INTELECTO", "VONTADE", "PERCEPÇÃO", "DEFESA",
                "SAÚDE", "TXCURA", "TAMANHO", "DESLOCAMENTO", "PODER", "DANO",
                "INSANIDADE", "CORRUPÇÃO"};
        dropdownAtributo = new JComboBox<>(valoresAtributos);

        JLabel labelId = new JLabel("Id da arma:");
        JLabel labelAtrAtu= new JLabel("Atributo para atualizar:");
        JLabel labelValor = new JLabel("Valor:");
        textId = new JTextField(5);
        textValor = new JTextField(20);

        JButton CriarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelId);
        panel.add(textId);
        panel.add(labelAtrAtu);
        panel.add(dropdownVariavel);
        panel.add(labelValor);
        panel.add(textValor);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textId.getText());
                String varName = (String) dropdownVariavel.getSelectedItem();
                String valor = textValor.getText();

                Command atualizarArmaCommand = new AtualizarArmaCommand(screen,id,varName,valor);
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
