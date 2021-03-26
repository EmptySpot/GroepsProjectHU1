package userInterfaceLaag;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InloggenController {

    public void initialize() {
    }
    public void inloggen(ActionEvent actionEvent) throws IOException {
        //if gebruikersnaam == txt.gebruikersnaam en wachtwoord = wachtwoord.text
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent root = loader.load();

        Scene homePage = new Scene(root);
        Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePage);
        appStage.show();
    }
}
