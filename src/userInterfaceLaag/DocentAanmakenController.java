package userInterfaceLaag;

import code.tester.DatabaseInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class DocentAanmakenController {
    @FXML private Label errorLocatie;
    @FXML private TextField docentnaam;
    @FXML private TextField wachtwoord;
    public void opslaan(MouseEvent mouseEvent) throws IOException, SQLException {
        errorLocatie.setText("");
        if(docentnaam.getText().equals("")){
            errorLocatie.setText("Geef een docentnaam op");
        } else if (wachtwoord.getText().equals("")){
            errorLocatie.setText("Geef een wachtwoord");
        } else {
            String docentid = DatabaseInfo.setDocent(docentnaam.getText(),wachtwoord.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("HU agenda");
            alert.setHeaderText("Dit is de gebruikersnaam van de docent");
            alert.setContentText("Gebruikersnaam: " + docentid);
            Optional<ButtonType> result = alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }
    public void cancelButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}
