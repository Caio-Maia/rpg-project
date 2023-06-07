package main.java.infra;

import main.java.business.model.Arma;
import main.java.business.model.enums.Atributo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ArmaDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Arma(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, requisito TEXT NOT NULL, atributo TEXT NOT NULL, dano TEXT NOT NULL, propriedades TEXT NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Arma partida = (Arma) data;

        stmt.setString(1, partida.getNome());
        stmt.setString(2, partida.getRequisito());
        stmt.setString(3, partida.getAtributo().name());
        stmt.setString(4, partida.getDano());
        stmt.setString(5, partida.getPropriedades());

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
        String requisito = rs.getString("requisito");
        String atributo = rs.getString("atributo");
        String dano = rs.getString("dano");
        String propriedades = rs.getString("propriedades");

        T data = (T) new Arma(id, nome, requisito, Atributo.valueOf(atributo), dano, propriedades);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Arma arma = (Arma) data;
        stmt.setString(1, arma.getNome());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Arma(nome, requisito, atributo, dano, propriedade) VALUES(?,?,?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Arma";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Arma WHERE id = ?";
    }

    @Override
    public String getUpdateQuery(String attributeName) {
        return "UPDATE Arma SET " + attributeName + " = ? WHERE id = ?";
    }
}
