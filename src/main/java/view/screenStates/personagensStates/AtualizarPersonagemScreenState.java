package main.java.view.screenStates.personagensStates;

import main.java.business.model.Personagem;
import main.java.view.MainScreenDesktop;
import main.java.view.commands.Command;
import main.java.view.commands.VoltarTelaCommand;
import main.java.view.commands.personagensCommands.AtualizarPersonagemCommand;
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

public class AtualizarPersonagemScreenState extends JFrame implements ScreenState {
    private JTextField textId,textNome,textAncestralidade,textClasse,textDinheiro,textStatus,textEquipamentos,textItens,textTalentos;
    private JLabel labelNome,labelAcenstralidade,labelClasse,labelDinheiro,labelStatus,labelEquipamentos,labelItens,labelTalentos;
    private JButton atualizarBtn;
    private Integer criador,partida;
    @Override
    public void handleTela(MainScreenDesktop screen) {
        setTitle("Atualizar Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel labelId = new JLabel("Id do personagem:");
        textId = new JTextField(5);


        atualizarBtn = new JButton("Atualizar");
        JButton VoltarBtn = new JButton("Voltar");

        labelNome= new JLabel("Nome do Personagem:");
        labelAcenstralidade = new JLabel("Ancestralidade:");
        labelClasse = new JLabel("Classe:");
        labelDinheiro = new JLabel("Dinheiro:");
        labelStatus = new JLabel("Status:");
        labelEquipamentos = new JLabel("Equipamentos:");
        labelItens = new JLabel("Itens:");
        labelTalentos = new JLabel("Talentos:");
        textNome = new JTextField(20);
        textAncestralidade = new JTextField(20);
        textClasse = new JTextField(20);
        textDinheiro = new JTextField(20);
        textStatus  = new JTextField(20);
        textEquipamentos = new JTextField(20);
        textItens = new JTextField(20);
        textTalentos = new JTextField(20);

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
                Integer id = Integer.parseInt(textId.getText());
                String nome = textNome.getText();
                String ancestralidade = textAncestralidade.getText();
                String classe = textClasse.getText();
                String dinheiro = textDinheiro.getText();

                ArrayList<Integer> status = converterEmLista(textStatus.getText());
                ArrayList<Integer> equipamentos = converterEmLista(textEquipamentos.getText());
                ArrayList<Integer> itens = converterEmLista(textItens.getText());
                ArrayList<Integer> talentos = converterEmLista(textTalentos.getText());


                Personagem personagem = new Personagem(criador,nome,partida,ancestralidade,classe,dinheiro,status,equipamentos,itens,talentos);

                Command atualizarPersonagemCommand = new AtualizarPersonagemCommand(screen,id,personagem);
                atualizarPersonagemCommand.execute();
            }
        });

        VoltarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command voltarTelaCommand = new VoltarTelaCommand(screen);
                voltarTelaCommand.execute();
            }
        });
    }

    private void busca(Integer textoDigitado, MainScreenDesktop screen, JPanel panel) {
        List ids = new ArrayList<>();
        ids.add(textoDigitado);
        Map<Integer, Personagem> lista = screen.getPersonagemManager().getPersonagensByIds(ids);
        Personagem personagem = null;
        if (!lista.isEmpty()) {
            Iterator<Personagem> iterator = lista.values().iterator();
            if (iterator.hasNext()) {
                personagem = iterator.next();
                montarTela(panel,personagem);
            }
        }
    }

    private void montarTela(JPanel panel, Personagem personagem){
        criador = personagem.getCriador();
        partida = personagem.getPartida();

        textNome.setText(personagem.getNome());
        textAncestralidade.setText(personagem.getAncestralidade());
        textClasse.setText(personagem.getClasse());
        textDinheiro.setText(personagem.getDinheiro());
        textStatus.setText(personagem.getStatusesId().toString());
        textEquipamentos.setText(personagem.getEquipamentosId().toString());
        textItens.setText(personagem.getItensId().toString());
        textTalentos.setText(personagem.getTalentosId().toString());

        panel.add(labelNome);
        panel.add(textNome);
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

        panel.add(atualizarBtn);
        panel.updateUI();
    }

    private void desmontaTela(JPanel panel){
        panel.remove(labelNome);
        panel.remove(textNome);
        panel.remove(labelAcenstralidade);
        panel.remove(textAncestralidade);
        panel.remove(labelClasse);
        panel.remove(textClasse);
        panel.remove(labelDinheiro);
        panel.remove(textDinheiro);
        panel.remove(labelStatus);
        panel.remove(textStatus);
        panel.remove(labelEquipamentos);
        panel.remove(textEquipamentos);
        panel.remove(labelItens);
        panel.remove(textItens);
        panel.remove(labelTalentos);
        panel.remove(textTalentos);

        panel.remove(atualizarBtn);
        panel.updateUI();
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
