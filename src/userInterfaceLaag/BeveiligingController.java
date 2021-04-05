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

public class BeveiligingController {
    @FXML private TextField pogingenTextfield;
    @FXML private Label meldingLabel;
    @FXML private TextField gebruikersnaamInput;
    @FXML private Label geenInvoer;
    public void deblokkeren(MouseEvent mouseEvent) throws SQLException, IOException {

        if(gebruikersnaamInput.getText()==""){
            geenInvoer.setText("Voer een leerlingnummer in!");
        }else{
        DatabaseInfo.setDeblokkeren(gebruikersnaamInput.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Beveiliging.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HU agenda");
        alert.setContentText("U heeft succesvol het account met id: " + gebruikersnaamInput.getText() + " gedeblokkeerd");
        Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public void opslaan(ActionEvent actionEvent) throws SQLException {
        DatabaseInfo.setBlokkeerAttempts(Integer.parseInt(pogingenTextfield.getText()));
        meldingLabel.setText("U heeft succesvol het aantal pogingen aangepast naar: " + pogingenTextfield.getText());
    }
}