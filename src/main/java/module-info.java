module com.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.example.schoolmanager to javafx.fxml;
    exports com.example.schoolmanager;
    opens  com.example.Controllers to javafx.fxml;
    exports com.example.Controllers;
}