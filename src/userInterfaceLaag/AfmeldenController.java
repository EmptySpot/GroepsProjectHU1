package userInterfaceLaag;

import code.tester.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AfmeldenController {
    @FXML private Label vakNaam;
    @FXML private Label lesNaam;
    @FXML private Label verplicht;
    @FXML private Label lesgetal;
    @FXML private Label datum;
    @FXML private Label docentNaam;
    @FXML private Label klasNaam;
    @FXML private Label statusLabel;
    @FXML private TextArea redeneringTextArea;
    @FXML private ToggleGroup aanwezigheid;

    public void initialize() {
        OnlineLes l = SelectedStatics.getLes();
        if (l != null) {
            vakNaam.setText(l.getVakNaam());
            lesNaam.setText(l.getLesNaam());
            lesgetal.setText(l.getLesCode());
            datum.setText(l.getDatum().toString() + " " + l.getTime());
            docentNaam.setText(l.getDocent().toString());
            klasNaam.setText(l.getKlas().toString());
            if(l.getStatus()!=null){
                statusLabel.setText("Docent is: " + l.getStatus());
            }
            boolean verplichting = l.getVerplicht();
            if (verplichting) {
                verplicht.setText("Ja");
                verplicht.setStyle("-fx-text-fill: red;");
            } else {
                verplicht.setText("Nee");
                verplicht.setStyle("-fx-text-fill: green;");
            }
        }
    }


    public void mousePressedDashboard(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedKalender(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedGeschiedenis(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Geschiedenis.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }


    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void cancelButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void opslaanButton(MouseEvent mouseEvent) throws IOException {

        //TODO: Niet aan de error zitten, hij is bekend en huidig correct.
        OnlineLes les = SelectedStatics.getLes();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        String extrainformatie = redeneringTextArea.getText();
        RadioButton selectedRadioButton = (RadioButton) aanwezigheid.getSelectedToggle();
        String aanwezigheidTekst = selectedRadioButton.getText();
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();

        if(huidigeGebruiker instanceof Leerling){
            Leerling huidigeLeerling = (Leerling) huidigeGebruiker;
            huidigeLeerling.setAanwezigheid(extrainformatie, aanwezigheidTekst, les) ;
        }
        else if(huidigeGebruiker instanceof Docent){
            Docent huidigeDocent = (Docent) huidigeGebruiker;
            les.setStatus(aanwezigheidTekst);
        }
        //TODO: Niet aan de error zitten, hij is bekend en huidig correct.
    }
}
