package main.java.infra;

import main.java.business.model.Personagem;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PersonagemDatabaseStrategy implements DatabaseStrategy{
    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Personagens (id INTEGER PRIMARY KEY AUTOINCREMENT,usuario INTEGER NOT NULL,nome TEXT NOT NULL, partida INTEGER NOT NULL, FOREIGN KEY(partida) REFERENCES Partidas(id),FOREIGN KEY(usuario) REFERENCES Usuarios(id));";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Personagem personagem = (Personagem) data;

        stmt.setInt(1, personagem.getCriador());
        stmt.setString(2, personagem.getNome());
        stmt.setInt(3, personagem.getPartida());
    }

    @Override
    public <T> Map<Integer, T> loadData(ResultSet rs) throws SQLException, IOException, ClassNotFoundException {
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
        int usuario = rs.getInt("usuario");
        String nome = rs.getString("nome");
        int partida = rs.getInt("partida");

        T data = (T) new Personagem(id, usuario, nome, partida);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Personagem personagem = (Personagem) data;
        stmt.setString(1, personagem.getNome());
    }
    @Override
    public String getSaveQuery() {
        return "INSERT INTO Personagens(usuario, nome, partida) VALUES(?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Personagens";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Persoangens WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Personagens SET nome = ? WHERE id = ?";
    }

}
