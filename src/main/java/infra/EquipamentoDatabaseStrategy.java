package main.java.infra;

import main.java.business.model.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EquipamentoDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Equipamento(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, defesa TEXT NOT NULL,"+
                " requisito TEXT NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Equipamento equipamento = (Equipamento) data;

        stmt.setString(1, equipamento.getNome());
        stmt.setString(2, equipamento.getDefesa());
        stmt.setString(3, equipamento.getRequisito());

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
        String defesa = rs.getString("defesa");
        String requisito = rs.getString("requisito");

        T data = (T) new Equipamento(id, nome, defesa, requisito);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Equipamento equipamento = (Equipamento) data;
        stmt.setString(1, equipamento.getNome());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Equipamento(nome, defesa, requisito) VALUES(?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Equipamento";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Equipamento WHERE id = ?";
    }

    @Override
    public String getUpdateQuery(String attributeName) {
        return "UPDATE Equipamento SET " + attributeName + " = ? WHERE id = ?";
    }
}
