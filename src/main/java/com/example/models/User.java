package com.example.models;

import com.example.DataConfig.dataconfig;
import com.example.Interface.connectInterface;
import com.example.Interface.userInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User implements connectInterface, userInterface {
    private int id ;
    private String email;
    private  String password;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Connection connection;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void imscription(User user) throws SQLException {
        connection = dataconfig.getconnection();
        System.out.println(connection);
        if (connection != null) {
            String req = "INSERT INTO user (email, password) VALUES (?, ?)";
            PreparedStatement prepareStatement = this.connection.prepareStatement(req);
            prepareStatement.setString(1, user.getEmail());
            prepareStatement.setString(2, user.getPassword());
            int row = prepareStatement.executeUpdate();



            System.out.printf(String.valueOf(row));
            prepareStatement.close();
            this.connection.close();
        }

    }

    @Override
    public boolean connect(User user) throws SQLException {
        connection = dataconfig.getconnection();
        int rows = 0;
        if (connection != null){
            String req = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(req);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                rows++;
            }
            preparedStatement.close();
            this.connection.close();
        }
        return rows > 0;
    }

    @Override
    public List<User> list() throws SQLException {
        return List.of();
    }
}
