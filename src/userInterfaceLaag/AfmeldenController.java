package userInterfaceLaag;

import code.tester.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

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
    @FXML private Button opslaanButton;

    public void initialize() throws SQLException {
        OnlineLes l = SelectedStatics.getLes();
        if (l != null) {
            vakNaam.setText(l.getVakNaam());
            lesNaam.setText(l.getLesNaam());
            lesgetal.setText(l.getLesCode());
            lesgetal.setText("haha");
            lesgetal.setText(l.getDuratie());
            datum.setText(l.getDatum().toString() + " " + l.getTime());
            docentNaam.setText(l.getDocent().toString());
            klasNaam.setText(l.getKlas().toString());
            String status = l.getStatus();
            if(!status.equals("Aanwezig")){
                if(status.equals("Gesloten")){
                    opslaanButton.setVisible(false);
                    statusLabel.setText("Deze les is gesloten");
                } else {
                    statusLabel.setText("Docent is: " + l.getStatus());
                }
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



    public void cancelButton(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void opslaanButton(MouseEvent mouseEvent) throws IOException, SQLException {

        OnlineLes les = SelectedStatics.getLes();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kalender.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        String extrainformatie = redeneringTextArea.getText();
        RadioButton selectedRadioButton = (RadioButton) aanwezigheid.getSelectedToggle();
        String aanwezigheidTekst = selectedRadioButton.getText();
        Persoon huidigeGebruiker = SelectedStatics.getPersoon();

        if(huidigeGebruiker instanceof Leerling){
            Leerling huidigeLeerling = (Leerling) huidigeGebruiker;
            huidigeLeerling.updateAanwezigheid(huidigeLeerling.getAanwezigheidLes(les), aanwezigheidTekst, extrainformatie);
            Aanwezigheid a = new Aanwezigheid(huidigeLeerling, extrainformatie, aanwezigheidTekst, les);
            DatabaseInfo.setAbsentieLeerlingLes(a);

        }
        else if(huidigeGebruiker instanceof Docent){
            Docent huidigeDocent = (Docent) huidigeGebruiker;
            Aanwezigheid a = new Aanwezigheid(huidigeDocent, aanwezigheidTekst, les);
            DatabaseInfo.setAbsentieLeerlingLes(a);
        }
    }
}
