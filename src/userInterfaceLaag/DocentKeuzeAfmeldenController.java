package userInterfaceLaag;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class DocentKeuzeAfmeldenController {

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

    public void mousePressedCancel(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }


    public void mousePressedUitloggen(MouseEvent mouseEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Agenda");
        alert.setContentText("Weet je zeker dat je wilt uitloggen?");
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("Pictures/cropped-cropped-hogeschool-utrecht-logo.png"));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL) {
            alert.hide();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inloggen.fxml"));
            mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
        }
    }

    public void mousePressedKlas(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("KlassenLijst.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }

    public void mousePressedSelf(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Afmelden.fxml"));
        mousePressedControle.mousePressedVerwerker(mouseEvent, loader);
    }
}
