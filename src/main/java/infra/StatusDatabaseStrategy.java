package main.java.infra;

import main.java.business.model.Status;
import main.java.business.model.enums.Atributo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusDatabaseStrategy implements DatabaseStrategy {

    @Override
    public void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Status(id INTEGER PRIMARY KEY AUTOINCREMENT, atributo TEXT NOT NULL, valor TEXT NOT NULL,"+
                " temModificador BOOLEAN NOT NULL CHECK (temModificador IN (0, 1)));";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Override
    public void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException {
        Status status = (Status) data;

        stmt.setString(1, status.getAtributo().name());
        stmt.setString(2, status.getValor());
        stmt.setBoolean(3, status.getTemModificador());

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
        String atributo = rs.getString("atributo");
        String valor = rs.getString("valor");
        Boolean temModificador = rs.getInt("temModificador") != 0;

        T data = (T) new Status(id, Atributo.valueOf(atributo), valor, temModificador);
        return data;
    }

    @Override
    public void createObjectUpdate(PreparedStatement stmt, Object data) throws SQLException {
        Status status = (Status) data;
        stmt.setString(1, status.getValor());
        stmt.setBoolean(2, status.getTemModificador());
    }

    @Override
    public String getSaveQuery() {
        return "INSERT INTO Status(atributo, valor, temModificador) VALUES(?,?,?)";
    }

    @Override
    public String getLoadQuery() {
        return "SELECT * FROM Status";
    }

    @Override
    public String getLoadByListOfIdsQuery(List<Integer> ids) {
        return "SELECT * FROM Status WHERE id IN (" + ids.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Status WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Status SET valor = ?, temModificador = ? WHERE id = ?";
    }
}
