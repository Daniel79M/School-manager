package com.example.Interface;

import com.example.models.Classroom;

import java.sql.SQLException;
import java.util.List;

public interface classroomInterface {
    List<Classroom> list () throws SQLException;
}
