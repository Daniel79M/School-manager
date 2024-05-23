package com.example.DataConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public interface dataconfig {
    String host = "localhost";

    String port = "3306";

    String username = "root";

    String password = "";

    String database = "school_manager";

    String URL = "jdbc:mysql://"+host+":"+port+"/"+database;

    static Connection getconnection(){
        try{
            return DriverManager.getConnection (URL, username, password);
        }catch (Exception e){
            return null;
        }
    }
}
