package main.java.infra;

import main.java.business.model.Ataque;
import main.java.business.model.enums.TipoAtaque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtaqueDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Ataque(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, distancia TEXT NOT NULL,"+
                " tipoAtaque TEXT NOT NULL, contraAtaque TEXT NOT NULL, dadiPerd INTEGER NOT NULL, dano TEXT NOT NULL, critico TEXT NOT NULL, descricao TEXT NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Ataque ataque = (Ataque) data;

        stmt.setString(1, ataque.getNome());
        stmt.setString(2, ataque.getDistancia());
        stmt.setString(3, ataque.getTipoAtaque().name());
        stmt.setString(4, ataque.getContraAtaque().name());
        stmt.setInt(5, ataque.getDadiPerd());
        stmt.setString(6, ataque.getDano());
        stmt.setString(7, ataque.getCritico());
        stmt.setString(8, ataque.getDescricao());

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
        String distancia = rs.getString("distancia");
        String tipoAtaque = rs.getString("tipoAtaque");
        String contraAtaque = rs.getString("contraAtaque");
        Integer dadiPerd = rs.getInt("dadiPerd");
        String dano = rs.getString("dano");
        String critico = rs.getString("critico");
        String descricao = rs.getString("descricao");

        T data = (T) new Ataque(id, nome, distancia, TipoAtaque.valueOf(tipoAtaque), TipoAtaque.valueOf(contraAtaque), dadiPerd, dano, critico, descricao);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Ataque ataque = (Ataque) data;
        stmt.setString(1, ataque.getNome());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Arma(nome, distancia, tipoAtaque, contraAtaque, dadiPerd, dano, critico, descricao) VALUES(?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Ataque";
    }

    @Override
    public String getLoadByListOfIdsQuery(List<Integer> ids) {
        return "SELECT * FROM Ataque WHERE id IN (" + ids.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Ataque WHERE id = ?";
    }

    @Override
    public String getUpdateQuery(String attributeName) {
        return "UPDATE Ataque SET " + attributeName + " = ? WHERE id = ?";
    }
}
