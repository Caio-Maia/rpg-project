package main.java.infra;

import main.java.business.model.Talento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalentoDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Talento(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, descricao TEXT NOT NULL,"+
                " temConjuracoes BOOLEAN NOT NULL CHECK (temConjuracoes IN (0, 1)), qteConjuracoesMax INTEGER NOT NULL, qteConjuracoesRest INTEGER NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Talento talento = (Talento) data;

        stmt.setString(1, talento.getNome());
        stmt.setString(2, talento.getDescricao());
        stmt.setBoolean(3, talento.getTemConjuracoes());
        stmt.setInt(4, talento.getQteConjuracoesMax());
        stmt.setInt(5, talento.getQteConjuracoesRest());

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
        Boolean temConjuracoes = rs.getInt("temConjuracoes") != 0;
        Integer qteConjuracoesMax = rs.getInt("qteConjuracoesMax");
        Integer qteConjuracoesRest = rs.getInt("qteConjuracoesRest");

        T data = (T) new Talento(id, nome, descricao, temConjuracoes, qteConjuracoesMax, qteConjuracoesRest);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Talento talento = (Talento) data;
        stmt.setString(1, talento.getNome());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Talento(nome, descricao, temConjuracoes, qteConjuracoesMax, qteConjuracoesRest) VALUES(?,?,?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Talento";
    }

    @Override
    public String getLoadByListOfIdsQuery(List<Integer> ids) {
        return "SELECT * FROM Talento WHERE id IN (" + ids.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Talento WHERE id = ?";
    }

    @Override
    public String getUpdateQuery(String attributeName) {
        return "UPDATE Talento SET " + attributeName + " = ? WHERE id = ?";
    }
}
