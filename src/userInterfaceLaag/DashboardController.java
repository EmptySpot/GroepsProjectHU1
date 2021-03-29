package userInterfaceLaag;

import code.tester.Docent;
import code.tester.Leerling;
import code.tester.SelectedStatics;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class DashboardController {
    @FXML
    private Label persoonNaam;

    public void initialize() {
        if (SelectedStatics.getStatus().equals("Leerling")) {
            Leerling leerling = (Leerling) SelectedStatics.getPersoon();
            persoonNaam.setText(leerling.getLeerlingNaam());
            System.out.println(leerling.getLeerlingnummer());
        } else if (SelectedStatics.getStatus().equals("Docent")) {
            Docent docent = (Docent) SelectedStatics.getPersoon();
            persoonNaam.setText(docent.getDocentNaam());
            System.out.println(docent.getDocentNaam());
        }
    }
}
