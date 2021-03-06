package userInterfaceLaag;

import code.tester.DatabaseInfo;
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

public class KlasAanmakenController {
    @FXML
    private TextField klasnaam;
    @FXML
    private Label errorLocatie;

    public void opslaan(MouseEvent mouseEvent) throws IOException, SQLException {
        errorLocatie.setText("");
        if (klasnaam.getText().equals("")) {
            errorLocatie.setText("Geef een klasnaam op");
        } else {
            DatabaseInfo.setKlas(klasnaam.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("HU agenda");
            alert.setContentText("U heeft succesvol klas: " + klasnaam.getText() + "aangemaakt.");
            Optional<ButtonType> result = alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }
        public void cancelButton (MouseEvent mouseEvent) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }


