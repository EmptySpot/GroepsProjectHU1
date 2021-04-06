package userInterfaceLaag;

import code.tester.DatabaseInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.SQLException;

public class WachtwoordOpvragenController {
    @FXML private Label fouteGebruiker;
    @FXML private TextField gebruikersnaamTextfield;

    public void wachtwoordOpvragen() throws SQLException {
        if(gebruikersnaamTextfield.getText().matches("-?(0|[1-9]\\d*)")) {
            String wachtwoord = DatabaseInfo.getWachtwoord(gebruikersnaamTextfield.getText());
            if(wachtwoord != null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("HU agenda");
                alert.setHeaderText("Dit is het wachtwoord van account: " + gebruikersnaamTextfield.getText());
                alert.setContentText(wachtwoord);
                alert.show();
            } else {
                fouteGebruiker.setText("Niet bestaande gebruikersnaam");
            }
        } else {
            fouteGebruiker.setText("Ongeldige gebruikersnaam");
        }
    }
}
