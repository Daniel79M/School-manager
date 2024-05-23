package com.example.Controllers;

import com.example.models.User;
import com.example.schoolmanager.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectController {
    private String email;
    private String password;
    private String parms;
    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField emailTextField;


    @FXML
    private void toConnect() throws IOException, SQLException {
        this.email = emailTextField.getText().trim();
        this.password = passwordPasswordField.getText().trim();
        this.parms = email + "   " + password;

        if (!email.isEmpty() && password.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            if (user.connect(user)){
                Stage stage = (Stage) emailTextField.getScene().getWindow();
                Stage newStage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull (HelloApplication.class.getResource("Student_View.fxml")));
                newStage.setTitle("School Manager");
                newStage.setScene(new Scene(root));
                newStage.show();
                stage.close();

            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Attention");
                alert.setContentText("les information inserés ne sont pas correcte");
                alert.setContentText(parms);
                alert.showAndWait();
            }
        }
    }
    @FXML
    private void oninscription() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("inscription_View.fxml")));
        Stage stage = (Stage) emailTextField.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    private void toconnect() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hello-view.fxml")));
        Stage stage = (Stage) emailTextField.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    @FXML
    private void onregister() throws IOException, SQLException {
        this.email = emailTextField.getText().trim();
        this.password = passwordPasswordField.getText();
        if (!email.isEmpty() && !password.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.imscription(user);
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hello-view.fxml")));
            Stage stage = (Stage) emailTextField.getScene().getWindow();
            stage.setScene(new Scene(root));

//            stage initi = (stage) usernameTextField.getScene().getWindow();
//            initi
        }
    }

}
