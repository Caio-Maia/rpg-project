package main.java.infra;

import main.java.business.model.Partida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidaDatabaseStrategy implements DatabaseStrategy {
    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Partidas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, mestre INTEGER NOT NULL, FOREIGN KEY(mestre) REFERENCES Usuarios(id));";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Partida partida = (Partida) data;

        stmt.setString(1, partida.getNome());
        stmt.setInt(2, partida.getMestre());

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
        int mestre = rs.getInt("mestre");

        T data = (T) new Partida(id, nome, mestre);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Partida partida = (Partida) data;
        stmt.setString(1, partida.getNome());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Partidas(nome, mestre) VALUES(?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Partidas";
    }

    @Override
    public String getLoadByListOfIdsQuery(List<Integer> ids) {
        return "SELECT * FROM Partidas WHERE id IN (" + ids.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Partidas WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Partidas SET nome = ? WHERE id = ?";
    }

}
