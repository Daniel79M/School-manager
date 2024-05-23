package com.example.models;

import com.example.DataConfig.dataconfig;
import com.example.Interface.studentInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class Student implements studentInterface  {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private int state = 0;
    private Connection connection;
    private int Classroom;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getClassroom() {
        return Classroom;
    }

    public void setClassroom(int classroom) {
        Classroom = classroom;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public List<Student> list() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Student student) throws SQLException {
        connection = dataconfig.getconnection();
        if (connection != null) {
            String req = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth , state) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareCall(req);
            preparedStatement.setString(1, student.getFirstname());
            preparedStatement.setString(2, student.getLastname());
            LocalDate dateOfBirth1 = getDateOfBirth();
            preparedStatement.setDate(3, (dateOfBirth1()));
            preparedStatement.setString(4, student.getPlaceOfBirth());
            preparedStatement.setInt(5,  student.getState());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();

        }

    }

    private Date dateOfBirth1() {
        return null;
    }

    @Override
    public void update(Student student) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

}
