package main.java.view.screenStates.personagensStates;

import main.java.view.commands.Command;
import main.java.view.commands.personagensCommands.ListarPersonagensCommand;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonagensScreenState extends JFrame implements ScreenState {
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Operações com Personagens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        JButton listarPersonagens = new JButton("Listar Personagens");
        JButton criarPersonagem = new JButton("Criar Personagem");
        JButton atualizarPersonagem = new JButton("Atualizar Personagem");
        JButton excluirPersonagem = new JButton("Excluir Personagem");
        JButton VoltarBtn = new JButton("Voltar");

        panel.add(listarPersonagens);
        panel.add(criarPersonagem);
        panel.add(atualizarPersonagem);
        panel.add(excluirPersonagem);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);


        listarPersonagens.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command listarPersonagensCommand = new ListarPersonagensCommand(screen);
                listarPersonagensCommand.execute();
            }
        });

        criarPersonagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new CriarPersonagemScreenState());
            }
        });

        atualizarPersonagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new AtualizarPersonagemScreenState());
            }
        });

        excluirPersonagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setScreenState(new ExcluirPersonagemScreenState());
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
