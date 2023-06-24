module com.example.javafx_chatapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_chatapp to javafx.fxml;
    exports com.example.javafx_chatapp;
}