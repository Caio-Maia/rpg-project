package main.java.infra;

import main.java.business.model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDatabaseStrategy implements DatabaseStrategy {
    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, senha TEXT NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Usuario usuario = (Usuario) data;

        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());
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

    private <T> T createObjectFromResultSet(ResultSet rs) throws SQLException, IOException, ClassNotFoundException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String senha = rs.getString("senha");

        T data = (T) new Usuario(id, nome, senha);
        return data;
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Usuarios(nome, senha) VALUES(?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Usuarios";
    }
    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Usuarios WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Usuarios SET nome = ?, senha = ? WHERE id = ?";
    }


}
