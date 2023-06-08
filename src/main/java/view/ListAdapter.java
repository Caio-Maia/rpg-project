package main.java.view;

import main.java.business.model.*;
import main.java.business.model.enums.Atributo;
import main.java.business.model.enums.TipoAtaque;
import main.java.business.model.enums.TipoMagia;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ListAdapter extends AbstractTableModel {

    Map<Integer, ?> list;
    JTable table;

    public ListAdapter(Map<Integer, ?> list) {
        this.list = list;
    }

    public JTable criaListaArmas() {
        String[] columnNames = {"id", "nome", "requisito", "atributo", "dano", "propriedades"};
        Object[][] data = new Object[this.list.size()][6];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Arma arma = (Arma) entry.getValue();
            data[row][0] = arma.getId();
            data[row][1] = arma.getNome();
            data[row][2] = arma.getRequisito();
            data[row][3] = arma.getAtributo();
            data[row][4] = arma.getDano();
            data[row][5] = arma.getPropriedades();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public Component criaListaAtaques() {
        String[] columnNames = {"id","nome","distancia","tipoAtaque","contraAtaque","dadiPerd","dano","critico","descricao"};
        Object[][] data = new Object[this.list.size()][9];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Ataque ataque = (Ataque) entry.getValue();
            data[row][0] = ataque.getId();
            data[row][1] = ataque.getNome();
            data[row][2] = ataque.getDistancia();
            data[row][3] = ataque.getTipoAtaque();
            data[row][4] = ataque.getContraAtaque();
            data[row][5] = ataque.getDadiPerd();
            data[row][6] = ataque.getDano();
            data[row][7] = ataque.getCritico();
            data[row][8] = ataque.getDescricao();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public Component criaListaEquipamentos() {
        String[] columnNames = {"id","nome","defesa","requisito"};
        Object[][] data = new Object[this.list.size()][4];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();
            data[row][0] = equipamento.getId();
            data[row][1] = equipamento.getNome();
            data[row][2] = equipamento.getDefesa();
            data[row][3] = equipamento.getRequisito();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public Component criaListaItens() {
        String[] columnNames = {"id", "nome", "descrição","Tem Usos", "Qtd Usos", "Qtd"};
        Object[][] data = new Object[this.list.size()][6];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Item item = (Item) entry.getValue();
            data[row][0] = item.getId();
            data[row][1] = item.getNome();
            data[row][2] = item.getDescricao();
            data[row][3] = item.getTemUsos();
            data[row][4] = item.getQuantidadeUsos();
            data[row][5] = item.getQuantidade();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public Component criaListaMagias() {
        String[] columnNames = {"id","nome","tradicao","tipo","nivel","alvo","dano","critico","duracao","efeito","descricao","Ataque","Contra","Conjurações Restantes"};
        Object[][] data = new Object[this.list.size()][14];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Magia magia = (Magia) entry.getValue();
            data[row][0] = magia.getId();
            data[row][1] = magia.getNome();
            data[row][2] = magia.getTradicao();
            data[row][3] = magia.getTipoMagia();
            data[row][4] = magia.getNivel();
            data[row][5] = magia.getAlvo();
            data[row][6] = magia.getDano();
            data[row][7] = magia.getCritico();
            data[row][8] = magia.getDuracao();
            data[row][9] = magia.getEfeito();
            data[row][10] = magia.getDescricao();
            data[row][11] = magia.getTipoAtaque();
            data[row][12] = magia.getContraAtaque();
            data[row][13] = magia.getQteConjuracoesRest();

            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public JTable criaListaPartida() {
        String[] columnNames = {"id", "nome", "mestre"};
        Object[][] data = new Object[this.list.size()][3];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Partida partida = (Partida) entry.getValue();
            data[row][0] = partida.getId();
            data[row][1] = partida.getNome();
            data[row][2] = partida.getMestre();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public JTable criaListaPersonagem() {
        String[] columnNames = {"id", "nome", "criador", "partida"};
        Object[][] data = new Object[this.list.size()][4];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Personagem personagem = (Personagem) entry.getValue();
            data[row][0] = personagem.getId();
            data[row][1] = personagem.getNome();
            data[row][2] = personagem.getCriador();
            data[row][3] = personagem.getPartida();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public Component criaListaStatus() {
        String[] columnNames = {"id", "Atributo","Valor","Tem modificador"};
        Object[][] data = new Object[this.list.size()][4];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Status status = (Status) entry.getValue();
            data[row][0] = status.getId();
            data[row][1] = status.getAtributo();
            data[row][2] = status.getValor();
            data[row][3] = status.getTemModificador();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public Component criaListaTalentos() {
        String[] columnNames = {"id", "Nome","Descrição","Tem Conjuração","Conjurações Max", "Conjurações Restantes"};
        Object[][] data = new Object[this.list.size()][6];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Talento talento = (Talento) entry.getValue();
            data[row][0] = talento.getId();
            data[row][1] = talento.getNome();
            data[row][2] = talento.getDescricao();
            data[row][3] = talento.getTemConjuracoes();
            data[row][4] = talento.getQteConjuracoesMax();
            data[row][5] = talento.getQteConjuracoesRest();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }

    public JTable criaListaUsuario() {
        String[] columnNames = {"id", "login", "senha"};
        Object[][] data = new Object[this.list.size()][3];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Usuario usuario = (Usuario) entry.getValue();
            data[row][0] = usuario.getId();
            data[row][1] = usuario.getLogin();
            data[row][2] = usuario.getSenha();
            row++;
        }
        this.table = new JTable(data, columnNames);
        return table;
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return table.getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table.getValueAt(rowIndex, columnIndex);
    }
}
