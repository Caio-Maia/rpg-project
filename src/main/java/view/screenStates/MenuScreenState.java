package main.java.view.screenStates;

import main.java.view.commands.Command;
import main.java.view.commands.usuariosCommands.LogoutCommand;
import main.java.view.MainScreenDesktop;
import main.java.view.screenStates.armasStates.ArmasScreenState;
import main.java.view.screenStates.ataquesStates.AtaquesScreenState;
import main.java.view.screenStates.equipamentosStates.EquipamentosScreenState;
import main.java.view.screenStates.itensStates.ItensScreenState;
import main.java.view.screenStates.magiasStates.MagiasScreenState;
import main.java.view.screenStates.partidasStates.PartidasScreenState;
import main.java.view.screenStates.personagensStates.PersonagensScreenState;
import main.java.view.screenStates.statusStates.StatusScreenState;
import main.java.view.screenStates.talentosStates.TalentosScreenState;
import main.java.view.screenStates.usuariosStates.UsuariosScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Menu Pricipal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 450);

        JPanel panel = new JPanel();
        JButton armasBtn = new JButton("Operações com Armas");
        JButton ataquesBtn = new JButton("Operações com Ataques");
        JButton equipamentosBtn = new JButton("Operações com Equipamentos");
        JButton itensBtn = new JButton("Operações com Itens");
        JButton magiasBtn = new JButton("Operações com Magias");
        JButton partidasBtn = new JButton("Operações com Partidas");
        JButton personagensBtn = new JButton("Operações com Personagens");
        JButton statusBtn = new JButton("Operações com Status");
        JButton talentosBtn = new JButton("Operações com Talentos");
        JButton usuariosBtn = new JButton("Operações com Usuários");
        JButton relatoriosBtn = new JButton("Geração de Relatorios");
        JButton logoutBtn = new JButton("Realizar Logout");

        panel.add(armasBtn);
        panel.add(ataquesBtn);
        panel.add(equipamentosBtn);
        panel.add(itensBtn);
        panel.add(magiasBtn);
        panel.add(partidasBtn);
        panel.add(personagensBtn);
        panel.add(statusBtn);
        panel.add(talentosBtn);
        panel.add(usuariosBtn);
        panel.add(relatoriosBtn);
        panel.add(logoutBtn);

        getContentPane().add(panel);
        setVisible(true);

        armasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ArmasScreenState());
            }
        });

        ataquesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtaquesScreenState());
            }
        });

        equipamentosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new EquipamentosScreenState());
            }
        });

        itensBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ItensScreenState());
            }
        });

        magiasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new MagiasScreenState());
            }
        });

        partidasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new PartidasScreenState());
            }
        });

        personagensBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new PersonagensScreenState());
            }
        });

        statusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new StatusScreenState());
            }
        });

        talentosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new TalentosScreenState());
            }
        });

        usuariosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new UsuariosScreenState());
            }
        });

        relatoriosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new RelatoriosScreenState());
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command logoutCommand = new LogoutCommand(screen);
                logoutCommand.execute();
            }
        });

    }

    @Override
    public void fechaTela() {
        this.setVisible(false);
    }

}
