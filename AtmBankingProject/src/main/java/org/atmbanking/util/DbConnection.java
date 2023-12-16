package org.atmbanking.util;

import java.sql.*;

public class DbConnection {

    private Connection connection;
    private static DbConnection instance;
    private DbConnection(){
        createConnection();
    }
    public Connection getConnection(){
        try {
            if(connection.isClosed()){
                createConnection();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static DbConnection getInstance(){
        if(instance == null){
            instance = new DbConnection();
        }
        return instance;
    }
    private void createConnection() {
        try {
            connection = DriverManager.getConnection(Constant.DATABASE_URL,Constant.DATABASE_USERNAME,Constant.DATABASE_PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // ResultSet kapatma hatası
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                // PreparedStatement kapatma hatası
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Connection kapatma hatası
                e.printStackTrace();
            }
        }
    }










}
