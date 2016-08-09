package com.metrics.github.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {

    // docker IP will remain the same if container is built off same image
    // run docker with
    // docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpasswo -d 6af1d04a2f99
    // TODO: Tidy Up
    private static final String POSTGRES_HOST = "172.17.0.2";
    private static final int POSTGRES_PORT = 5432;
    private static final String POSTGRES_DATABASE = "postgres";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "mysecretpassword";

    private static Connection connection;

    public static Connection getConnection() {
        // ensure that postgres server is started, otherwise this will not establish a connection
        try {
            // specify which driver
            Class.forName("org.postgresql.Driver");
            // establish a connection
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s", POSTGRES_HOST, POSTGRES_PORT, POSTGRES_DATABASE), POSTGRES_USER, POSTGRES_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO handle properly
            e.printStackTrace();
        }
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTable(getConnection());

    }

    public static void createTable(Connection connection) {
        String createTableSQL = "CREATE TABLE DBUSER("
                + "USER_ID VARCHAR(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";
        try {
            final Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //TODO proper closing of resources
        }
    }
}
