package main.java.infra;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DatabaseStrategy {

    void createTableIfNotExists(Connection conn) throws SQLException;

    void setSaveParameters(PreparedStatement stmt, Object data) throws SQLException;

    <T> Map<Integer, T> loadData(ResultSet rs) throws SQLException;

    void createObjectUpdate(PreparedStatement stmt, Object newData) throws SQLException;

    String getDeleteQuery();

    String getUpdateQuery();

    String getSaveQuery();

    String getLoadQuery();

    String getLoadByListOfIdsQuery(List<Integer> ids);
}
