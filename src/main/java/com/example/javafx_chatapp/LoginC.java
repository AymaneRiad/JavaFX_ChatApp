package com.example.javafx_chatapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginC {
    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;
    @FXML
    protected void onLogin() throws IOException {
        if(usernameID.getText().equals("admin") && passwordID.getText().equals("admin")){
            Stage s = (Stage) usernameID.getScene().getWindow();
            FXMLLoader fx=new FXMLLoader(MainApp.class.getResource("AfterLogin.fxml"));
            Scene sc2 = new Scene(fx.load());
            s.setScene(sc2);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Authentification Error");
            alert.setHeaderText("Incorrect Username or Password");
            alert.setContentText("try another Password or username");
            alert.show();
        }

    }
}
