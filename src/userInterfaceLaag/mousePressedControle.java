package userInterfaceLaag;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class mousePressedControle {

    public static void mousePressedVerwerker(MouseEvent mouseEvent, FXMLLoader loader) throws IOException {
        String loc = loader.getLocation().getFile();
        loc = loc.substring(loc.lastIndexOf("/") + 1);
        if(loc.equals("Inloggen.fxml") || loc.equals("AccountAanmakenLeerling.fxml")){
            Parent root = loader.load();
            Scene homePage = new Scene(root);
            Stage appStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            appStage.setScene(homePage);
            appStage.show();
        } else {
            Node node;
            node = (Node)loader.load();
            var test = ((Node)mouseEvent.getTarget()).getScene().getWindow();
            AnchorPane pane = (AnchorPane) test.getScene().lookup("#ViewContainer");
            pane.getChildren().setAll(node);
        }

    }
}
