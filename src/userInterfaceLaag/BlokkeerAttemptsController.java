package userInterfaceLaag;

import code.tester.DatabaseInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.sql.SQLException;

public class BlokkeerAttemptsController {
    @FXML private TextField pogingenTextfield;
    @FXML private Label meldingLabel;
    public void cancelButton1(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void opslaan(ActionEvent actionEvent) throws SQLException {
        DatabaseInfo.setBlokkeerAttempts(Integer.parseInt(pogingenTextfield.getText()));
        meldingLabel.setText("U heeft succesvol het aantal pogingen aangepast naar: " + pogingenTextfield.getText());
    }
}
