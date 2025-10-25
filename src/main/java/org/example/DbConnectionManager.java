package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// nested class usage
public class DbConnectionManager {
    private final String URL = "jdbc:postgresql://localhost:5432/ShopsList";
    private final String USER = "postgres";
    private final  String PASSWORD = "GAbuniaya29";
    private Connection connection;


    private DbConnectionManager() {
        try {
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static class ReturnConnection{
        private static  final DbConnectionManager instance = new DbConnectionManager();
    }

    public static DbConnectionManager getConnectionInstance (){
        return  ReturnConnection.instance;
    }

    public Connection getDbConnection(){
        return connection;
    }

}
