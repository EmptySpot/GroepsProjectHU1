package userInterfaceLaag;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mousePressedControle {

    public static void mousePressedVerwerker(MouseEvent mouseEvent, FXMLLoader loader) throws IOException {
        Parent root = loader.load();

        Scene homePage = new Scene(root);
        Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePage);
        appStage.show();
    }
}
