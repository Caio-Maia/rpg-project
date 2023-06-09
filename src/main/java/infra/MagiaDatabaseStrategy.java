package main.java.infra;

import main.java.business.model.Magia;
import main.java.business.model.enums.TipoAtaque;
import main.java.business.model.enums.TipoMagia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagiaDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Magia(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, tradicao TEXT NOT NULL,"+
                "tipoMagia TEXT NOT NULL, nivel INTEGER NOT NULL, alvo TEXT NOT NULL, dano TEXT NOT NULL, critico TEXT NOT NULL,"+
                "duracao TEXT NOT NULL, efeito TEXT NOT NULL, descricao TEXT NOT NULL, tipoAtaque TEXT NOT NULL, contraAtaque TEXT NOT NULL,"+
                "qteConjuracoesRest INTEGER NOT NULL);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Magia magia = (Magia) data;

        stmt.setString(1, magia.getNome());
        stmt.setString(2, magia.getTradicao());
        stmt.setString(3, magia.getTipoMagia().name());
        stmt.setInt(4, magia.getNivel());
        stmt.setString(5, magia.getAlvo());
        stmt.setString(6, magia.getDano());
        stmt.setString(7, magia.getCritico());
        stmt.setString(8, magia.getDuracao());
        stmt.setString(9, magia.getEfeito());
        stmt.setString(10, magia.getDescricao());
        stmt.setString(11, magia.getTipoAtaque().name());
        stmt.setString(12, magia.getContraAtaque().name());
        stmt.setInt(13, magia.getQteConjuracoesRest());

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
        String tradicao = rs.getString("tradicao");
        String tipoMagia = rs.getString("tipoMagia");
        Integer nivel = rs.getInt("nivel");
        String alvo = rs.getString("alvo");
        String dano = rs.getString("dano");
        String critico = rs.getString("critico");
        String duracao = rs.getString("duracao");
        String efeito = rs.getString("efeito");
        String descricao = rs.getString("descricao");
        String tipoAtaque = rs.getString("tipoAtaque");
        String contraAtaque = rs.getString("contraAtaque");
        Integer qteConjuracoesRest = rs.getInt("qteConjuracoesRest");

        T data = (T) new Magia(id, nome, tradicao, TipoMagia.valueOf(tipoMagia), nivel, alvo, dano, critico, duracao, efeito, descricao, TipoAtaque.valueOf(tipoAtaque), TipoAtaque.valueOf(contraAtaque), qteConjuracoesRest);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Magia magia = (Magia) data;

        stmt.setString(1, magia.getNome());
        stmt.setString(2, magia.getTradicao());
        stmt.setString(3, magia.getTipoMagia().name());
        stmt.setInt(4, magia.getNivel());
        stmt.setString(5, magia.getAlvo());
        stmt.setString(6, magia.getDano());
        stmt.setString(7, magia.getCritico());
        stmt.setString(8, magia.getDuracao());
        stmt.setString(9, magia.getEfeito());
        stmt.setString(10, magia.getDescricao());
        stmt.setString(11, magia.getTipoAtaque().name());
        stmt.setString(12, magia.getContraAtaque().name());
        stmt.setInt(13, magia.getQteConjuracoesRest());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Magia(nome, tradicao, tipoMagia, nivel, alvo, dano, critico, duracao, efeito, descricao, tipoAtaque, contraAtaque, qteConjuracoesRest) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Magia";
    }

    @Override
    public String getLoadByListOfIdsQuery(List<Integer> ids) {
        return "SELECT * FROM Magia WHERE id IN (" + ids.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Magia WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Magia SET nome = ?, tradicao = ?, tipoMagia = ?, nivel = ?, alvo = ?, dano = ?, critico = ?, duracao = ?, efeito = ?, descricao = ?, tipoAtaque = ?, contraAtaque = ?, qteConjuracoesRest = ? WHERE id = ?";
    }
}
