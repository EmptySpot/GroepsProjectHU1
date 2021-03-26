package userInterfaceLaag;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class InloggenController {

    public void initialize() {
    }
    public void inloggen(ActionEvent actionEvent) throws IOException {
        //if gebruikersnaam == txt.gebruikersnaam en wachtwoord = wachtwoord.text
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("Afmelden.fxml"));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        initialize();

    }
}
