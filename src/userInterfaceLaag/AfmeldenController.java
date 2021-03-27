package userInterfaceLaag;

import code.tester.OnlineLes;
import code.tester.SelectedStatics;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    @FXML private TextArea redeneringTextArea;

    public void initialize() {
        OnlineLes l = SelectedStatics.getLes();
        if (l != null) {
            vakNaam.setText(l.getVakNaam());
            lesNaam.setText(l.getLesNaam());
            lesgetal.setText(l.getLesCode());
            datum.setText(l.getDatum().toString());
            boolean verplichting = l.getVerplicht();
            if (verplichting) {
                verplicht.setText("Ja");
                verplicht.setStyle("-fx-text-fill: red;");
            } else {
                verplicht.setText("Nee");
                verplicht.setStyle("-fx-text-fill: green;");
            }

            docentNaam.setText(("Hello"));
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

}
