package com.example.Interface;

import com.example.models.User;

import java.sql.SQLException;
import java.util.List;

public interface userInterface {
    List<User> list() throws SQLException;
}
