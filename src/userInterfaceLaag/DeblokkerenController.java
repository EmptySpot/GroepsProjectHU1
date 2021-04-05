package userInterfaceLaag;

import code.tester.DatabaseInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class DeblokkerenController {
    @FXML private TextField gebruikersnaamInput;
    public void deblokkeren(MouseEvent mouseEvent) throws SQLException, IOException {
        DatabaseInfo.setDeblokkeren(gebruikersnaamInput.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HU agenda");
        alert.setContentText("U heeft succesvol het account met id: " + gebruikersnaamInput.getText() + " gedeblokkeerd");
        Optional<ButtonType> result = alert.showAndWait();
    }

    public void cancelButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}
