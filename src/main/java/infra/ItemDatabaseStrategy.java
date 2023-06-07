package main.java.infra;

import main.java.business.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ItemDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Item(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, descricao TEXT NOT NULL,"+
                " temUsos BOOLEAN NOT NULL CHECK (temUsos IN (0, 1)), quantidadeUsos INTEGER NOT NULL, quantidade INTEGER NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Item item = (Item) data;

        stmt.setString(1, item.getNome());
        stmt.setString(2, item.getDescricao());
        stmt.setBoolean(3, item.getTemUsos());
        stmt.setInt(4, item.getQuantidadeUsos());
        stmt.setInt(5, item.getQuantidade());

    }

    @Override
    public <T> Map<Integer, T> loadData(ResultSet rs) throws SQLException {
        Map<Integer, T> dataMap = new HashMap<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            T data = createObjectFromResultSet(rs);
            dataMap.put(id, data);
        }
        return dataMap;
    }

    private <T> T createObjectFromResultSet(ResultSet rs) throws SQLException  {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String descricao = rs.getString("descricao");
        Boolean temUsos = rs.getInt("temUsos") != 0;
        Integer quantidadeUsos = rs.getInt("quantidadeUsos");
        Integer quantidade = rs.getInt("quantidade");

        T data = (T) new Item(id, nome, descricao, temUsos, quantidadeUsos, quantidade);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Item item = (Item) data;
        stmt.setString(1, item.getNome());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Item(nome, descricao, temUsos, quantidadeUsos, quantidade) VALUES(?,?,?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Item";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Item WHERE id = ?";
    }

    @Override
    public String getUpdateQuery(String attributeName) {
        return "UPDATE Item SET " + attributeName + " = ? WHERE id = ?";
    }
}
