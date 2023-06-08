package main.java.view.screenStates;

import main.java.view.*;
import main.java.view.commands.Command;
import main.java.view.commands.relatoriosCommands.GerarRelatorioHtmlCommand;
import main.java.view.commands.relatoriosCommands.GerarRelatorioPdfCommand;
import main.java.view.commands.VoltarTelaCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatoriosScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Geração de Relatorios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton relatorioHtmlBtn = new JButton("Gerar Relatorio HTML");
        JButton relatorioPdfBtn = new JButton("Gerar Relatorio PDF");
        JButton VoltarBtn = new JButton("Voltar");

        panel.add(relatorioHtmlBtn);
        panel.add(relatorioPdfBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);


        relatorioHtmlBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command gerarRelatorioHtmlCommand = new GerarRelatorioHtmlCommand(screen);
                gerarRelatorioHtmlCommand.execute();
            }
        });

        relatorioPdfBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command gerarRelatorioPdfCommand = new GerarRelatorioPdfCommand(screen);
                gerarRelatorioPdfCommand.execute();
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
