package main.java.view.screenStates.partidasStates;

import main.java.business.model.Partida;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.partidasCommands.AtualizarPartidaCommand;
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

public class AtualizarPartidaScreenState extends JFrame implements ScreenState {
    private JTextField textNome;
    private JTextField textId;
    private JLabel labelNome;
    private JButton atualizarBtn;
    private Integer criador;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar partida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId= new JLabel("Id da partida:");
        textId = new JTextField(5);
        labelNome= new JLabel("Nome da partida:");
        textNome = new JTextField(20);

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
                String nome = textNome.getText();
                Integer id = Integer.parseInt(textId.getText());

                Partida partida = new Partida(nome,criador);

                Command atualizarPartidaCommand = new AtualizarPartidaCommand(screen,id,partida);
                atualizarPartidaCommand.execute();
            }
        });

        VoltarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command voltarTelaCommand = new VoltarTelaCommand(screen);
                voltarTelaCommand.execute();
            }
        });
    }

    private void desmontaTela(JPanel panel) {
        panel.remove(labelNome);
        panel.remove(textNome);

        panel.remove(atualizarBtn);
        panel.updateUI();
    }

    private void busca(Integer textoDigitado, MainScreenDesktop screen, JPanel panel) {
        List ids = new ArrayList<>();
        ids.add(textoDigitado);
        Map<Integer, Partida> lista = screen.getPartidaManager().getPartidasByIds(ids);
        Partida partida = null;
        if (!lista.isEmpty()) {
            Iterator<Partida> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                partida = iterator.next();
                montarTela(panel,partida);
            }
        }
    }

    private void montarTela(JPanel panel, Partida partida) {
        textNome.setText(partida.getNome());
        criador = partida.getMestre();

        panel.add(labelNome);
        panel.add(textNome);

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }

}
