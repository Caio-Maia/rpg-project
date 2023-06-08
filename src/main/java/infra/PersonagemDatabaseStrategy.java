package main.java.infra;

import main.java.business.model.Personagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class PersonagemDatabaseStrategy implements DatabaseStrategy{
    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Personagens (id INTEGER PRIMARY KEY AUTOINCREMENT,usuario INTEGER NOT NULL,nome TEXT NOT NULL, partida INTEGER NOT NULL, ancestralidade TEXT NOT NULL, classe TEXT NOT NULL, dinheiro TEXT NOT NULL, statusesId TEXT NOT NULL, equipamentosId TEXT NOT NULL, itensId TEXT NOT NULL, talentosId TEXT NOT NULL, FOREIGN KEY(partida) REFERENCES Partidas(id),FOREIGN KEY(usuario) REFERENCES Usuarios(id));";
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
        stmt.setString(4, personagem.getAncestralidade());
        stmt.setString(5, personagem.getClasse());
        stmt.setString(6, personagem.getDinheiro());
        stmt.setString(7, personagem.getStatusesId().toString());
        stmt.setString(8, personagem.getEquipamentosId().toString());
        stmt.setString(9, personagem.getItensId().toString());
        stmt.setString(10, personagem.getTalentosId().toString());
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
        int usuario = rs.getInt("usuario");
        String nome = rs.getString("nome");
        int partida = rs.getInt("partida");
        String ancestralidade = rs.getString("ancestralidade");
        String classe = rs.getString("classe");
        String dinheiro = rs.getString("dinheiro");
        List<Integer> statusesId = Arrays.stream(rs.getString("statusesId").replaceAll("[\\[\\]]", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> equipamentosId = Arrays.stream(rs.getString("equipamentosId").replaceAll("[\\[\\]]", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> itensId = Arrays.stream(rs.getString("itensId").replaceAll("[\\[\\]]", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> talentosId = Arrays.stream(rs.getString("talentosId").replaceAll("[\\[\\]]", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        T data = (T) new Personagem(id, usuario, nome, partida, ancestralidade, classe, dinheiro, statusesId, equipamentosId, itensId, talentosId);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Personagem personagem = (Personagem) data;
        stmt.setString(1, personagem.getNome());
        stmt.setString(2, personagem.getAncestralidade());
        stmt.setString(3, personagem.getClasse());
        stmt.setString(4, personagem.getDinheiro());
        stmt.setString(5, personagem.getStatusesId().toString());
        stmt.setString(6, personagem.getEquipamentosId().toString());
        stmt.setString(7, personagem.getItensId().toString());
        stmt.setString(8, personagem.getTalentosId().toString());
    }
    @Override
    public String getSaveQuery() {
        return "INSERT INTO Personagens(usuario, nome, partida, ancestralidade, classe, dinheiro, statusesId, equipamentosId, itensId, talentosId) VALUES(?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Personagens";
    }

    @Override
    public String getLoadByListOfIdsQuery(List<Integer> ids) {
        return "SELECT * FROM Personagens WHERE id IN (" + ids.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Persoangens WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Personagens SET nome = ?, ancestralidade = ?, classe = ?, dinheiro = ?, statusesId = ?, equipamentosId = ?, itensId = ?, talentosId = ?  WHERE id = ?";
    }

}
