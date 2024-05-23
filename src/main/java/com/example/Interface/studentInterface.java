package com.example.Interface;

import com.example.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface studentInterface {
    List<Student> list() throws SQLException;
    void create(Student student) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(int id) throws SQLException;
}
