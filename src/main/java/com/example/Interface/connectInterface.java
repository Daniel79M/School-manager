package com.example.Interface;

import com.example.models.User;

import java.sql.SQLException;

public interface connectInterface {
    void imscription (User user) throws SQLException;
    boolean connect (User user) throws SQLException;

}
