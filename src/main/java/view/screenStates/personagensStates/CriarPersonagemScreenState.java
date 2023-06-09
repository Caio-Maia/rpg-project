package main.java.view.screenStates.personagensStates;

import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.personagensCommands.CriarPersonagemCommand;
import main.java.view.screenStates.ScreenState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CriarPersonagemScreenState extends JFrame implements ScreenState {
    private JTextField textNome,textCriador,textPartida,textAncestralidade,textClasse,textDinheiro,textStatus,textEquipamentos,textItens,textTalentos;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Criar novo Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelNome= new JLabel("Nome do Personagem:");
        JLabel labelCriador = new JLabel("Id do Criador:");
        JLabel labelPartida = new JLabel("Id da Partida:");
        JLabel labelAcenstralidade = new JLabel("Ancestralidade:");
        JLabel labelClasse = new JLabel("Classe:");
        JLabel labelDinheiro = new JLabel("Dinheiro:");
        JLabel labelStatus = new JLabel("Status:");
        JLabel labelEquipamentos = new JLabel("Equipamentos:");
        JLabel labelItens = new JLabel("Itens:");
        JLabel labelTalentos = new JLabel("Talentos:");
        textNome = new JTextField(20);
        textCriador = new JTextField(5);
        textPartida = new JTextField(5);
        textAncestralidade = new JTextField(20);
        textClasse = new JTextField(20);
        textDinheiro = new JTextField(20);
        textStatus  = new JTextField(20);
        textEquipamentos = new JTextField(20);
        textItens = new JTextField(20);
        textTalentos = new JTextField(20);

        JButton CriarBtn = new JButton("Criar");
        JButton VoltarBtn = new JButton("Voltar");

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelCriador);
        panel.add(textCriador);
        panel.add(labelPartida);
        panel.add(textPartida);
        panel.add(labelAcenstralidade);
        panel.add(textAncestralidade);
        panel.add(labelClasse);
        panel.add(textClasse);
        panel.add(labelDinheiro);
        panel.add(textDinheiro);
        panel.add(labelStatus);
        panel.add(textStatus);
        panel.add(labelEquipamentos);
        panel.add(textEquipamentos);
        panel.add(labelItens);
        panel.add(textItens);
        panel.add(labelTalentos);
        panel.add(textTalentos);

        panel.add(CriarBtn);
        panel.add(VoltarBtn);

        getContentPane().add(panel);
        setVisible(true);

        CriarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                Integer criador = Integer.parseInt(textCriador.getText());
                Integer partida = Integer.parseInt(textPartida.getText());
                String ancestralidade = textAncestralidade.getText();
                String classe = textClasse.getText();
                String dinheiro = textDinheiro.getText();

                ArrayList<Integer> status = converterEmLista(textStatus.getText());
                ArrayList<Integer> equipamentos = converterEmLista(textEquipamentos.getText());
                ArrayList<Integer> itens = converterEmLista(textItens.getText());
                ArrayList<Integer> talentos = converterEmLista(textTalentos.getText());

                Command criarPersonagemCommand = new CriarPersonagemCommand(screen,criador,nome,partida,ancestralidade,classe,dinheiro,status,equipamentos,itens,talentos);
                criarPersonagemCommand.execute();
            }
        });

        VoltarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command voltarTelaCommand = new VoltarTelaCommand(screen);
                voltarTelaCommand.execute();
            }
        });
    }

    private ArrayList<Integer> converterEmLista(String entrada){
        String[] numeros = entrada.replaceAll(" ","").replaceAll("[\\[\\]]", "").split(",");
        ArrayList<Integer> retorno = new ArrayList<>();

        for (String numero : numeros) {
            int valor = Integer.parseInt(numero);
            retorno.add(valor);
        }
        return retorno;
    }

    @Override
    public void fechaTela() {
        setVisible(false);
    }
}
