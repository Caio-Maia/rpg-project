package main.java.view;

import main.java.business.model.Partida;
import main.java.business.model.Personagem;
import main.java.business.model.Usuario;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Map;

public class ListAdapter extends AbstractTableModel {

    Map<Integer, ?> list;
    JTable table;

    public ListAdapter(Map<Integer, ?> list) {
        this.list = list;
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

    public JTable criaListaPartida() {
        String[] columnNames = {"id", "nome", "mestre", "personagens"};
        Object[][] data = new Object[this.list.size()][4];
        int row = 0;
        for (Map.Entry<Integer, ?> entry : this.list.entrySet()) {
            Partida partida = (Partida) entry.getValue();
            data[row][0] = partida.getId();
            data[row][1] = partida.getNome();
            data[row][2] = partida.getMestre();
            data[row][3] = partida.getPersonagens();
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
