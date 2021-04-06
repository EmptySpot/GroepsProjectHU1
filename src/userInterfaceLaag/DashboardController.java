package userInterfaceLaag;

import code.tester.Docent;
import code.tester.Leerling;
import code.tester.SelectedStatics;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class DashboardController {
    @FXML
    private Label persoonNaam;

    public void initialize() {
        if (SelectedStatics.getStatus().equals("Leerling")) {
            Leerling leerling = (Leerling) SelectedStatics.getPersoon();
            persoonNaam.setText(leerling.getLeerlingNaam());
        } else if (SelectedStatics.getStatus().equals("Docent")) {
            Docent docent = (Docent) SelectedStatics.getPersoon();
            persoonNaam.setText(docent.getDocentNaam());
        }
    }


    public void HulpScherm(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterfaceLaag/HulpPagina.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}
