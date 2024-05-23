package com.example.Controllers;

import com.example.models.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.time.LocalDate;

public class StudentController {

    @FXML
    private TextField ClassroomTextField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private VBox lastnameTextfield;

    @FXML
    private TextField lastnametextfield;

    @FXML
    private TextField placeOfBirthTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    void onSubmitStudent() throws SQLException {
            String firstName = this.firstnameTextField.getText().trim();
            String lastName = this.lastnametextfield.getText().trim();
            LocalDate dateOfBirth = this.dateOfBirthField.getValue();
            String placeOfBirth = this.placeOfBirthTextField.getText().trim();
            int state = Integer.parseInt(this.stateTextField.getText().trim());
            int classroom = Integer.parseInt(this.ClassroomTextField.getText().trim());

            Student student = new Student();


            student.setFirstname(firstName);
            student.setLastname(lastName);
            student.setClassroom(classroom);
            try{
                student.setDateOfBirth(dateOfBirth);
            }catch (Exception e){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setContentText("Date format not valid");
                alert.showAndWait();
                return;
            }
            student.setPlaceOfBirth(placeOfBirth);
            student.setState(state);

            student.create(student);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setContentText("User registered successfully");
            alert.showAndWait();
        }


}
