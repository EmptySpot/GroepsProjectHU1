package userInterfaceLaag;

import code.tester.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AccountAanmakenLeerlingController {

    @FXML private TextField naam;
    @FXML private TextField studentnummer;
    @FXML private TextField wachtwoord;
    @FXML private TextField wachtwoordHerhaal;
    @FXML private ComboBox<Klas> klassenList;
    @FXML private Label errorLocatie;
    @FXML private CheckBox voorwaardenCheckbox;
    public void initialize() throws SQLException {
        List<Klas> klassen = School.getKlassen();
        klassenList.getItems().addAll(klassen);
    }
    public void klikVoorwaarden(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Algemene voorwaarden");
        alert.setHeaderText(null);
        alert.setContentText("-De minimum leeftijd om deze app te gebruiken is 16.\n" +
                "-Deze app wordt gebruikt voor het afmelden van leerlingen.\n" +
                "-Als u 3 keer verkeerd inlogd wordt uw account geblokkeerd.\n" +
                "-Als u akkoord gaat met deze voorwaarden dan slaan wij uw persoonlijke gegevens op in de database.\n" +
                "-In geval van problemen heeft u recht op een bepaalde servicekwaliteit en verschillende manieren om het probleem op te lossen.\n");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            alert.hide();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }
    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedAanmaken(MouseEvent mouseEvent) throws IOException, ClassNotFoundException, SQLException {
        errorLocatie.setText("");
        if(naam.getText().equals("")){
            errorLocatie.setText("Geef een naam op");
        } else if (wachtwoord.getText().equals("")){
            errorLocatie.setText("Geef een wachtwoord");
        } else if(!wachtwoord.getText().equals(wachtwoordHerhaal.getText())){
            errorLocatie.setText("Herhaal hetzelfde wachtwoord");
        } else if(klassenList.getSelectionModel().getSelectedItem()==null) {
            errorLocatie.setText("Selecteer je klas");
        } else if(!voorwaardenCheckbox.isSelected()){
                errorLocatie.setText("Ga akkoord met de voorwaarden");
        } else {
            String studentid = DatabaseInfo.setLeerling(naam.getText(),wachtwoord.getText(),klassenList.getSelectionModel().getSelectedItem());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("HU agenda");
            alert.setHeaderText("Dit is uw gebruikersnaam, vergeet dit niet!");
            alert.setContentText("Gebruikersnaam: " + studentid);
            Optional<ButtonType> result = alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }

    }
}
