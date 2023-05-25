package main.java.infra;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection getConnection();
}
